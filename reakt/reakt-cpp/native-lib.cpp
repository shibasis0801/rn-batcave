#include "jsi.h"
#include <string>
#include <jni.h>
#include <vector>
#include <string>
#include <map>
#include <unordered_map>
#include <stdexcept>
#include <optional>

using std::string;
using std::vector;
using std::unordered_map;
using std::make_shared;
using std::shared_ptr;
using std::function;
using std::optional;
using namespace facebook::jsi;

using PlatformFunction = function<
        optional<Value>(const vector<const Value *> &arguments)>;

#define repeat(i, n) for (size_t i = 0; (i) < (n); ++(i))
#define GUARD(ptr) if ((ptr) == nullptr) return nullptr
#define GUARD_DEFAULT(ptr, fallback) if ((ptr) == nullptr) return fallback

JavaVM *java;
JNIEnv *jni;

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    java = vm;
    if (vm->GetEnv(reinterpret_cast<void**>(&jni), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }

    return JNI_VERSION_1_6;
}
#include <android/log.h>
#define LOGV(fmt, str) __android_log_print(ANDROID_LOG_VERBOSE, "SHIBASIS", fmt,  str);
#define LOGE(fmt, str) __android_log_print(ANDROID_LOG_ERROR, "SHIBASIS", fmt, str);

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_myapplication_MainActivity_getStringFromNative(
        JNIEnv *env,
        jobject thiz,
        jobject counter) {

    auto javaClass = env->GetObjectClass(counter);
    auto getValue = env->GetMethodID(javaClass, "getValue", "()Ljava/lang/Object;");

    auto value = env->CallObjectMethod(counter, getValue);
    auto integerClass = env->GetObjectClass(value);

    auto intValue = env->GetMethodID(integerClass, "intValue", "()I");
    auto count = env->CallIntMethod(value, intValue);
    return count;
}



class Observable {
    std::unordered_map<int, std::function<void(int)>> listeners;

public:
    void setValue(JNIEnv *env, jobject data, jint number) {
        std::string message = "NATIVE C++ SHIBASIS" + std::to_string(number);
        LOGV("%s", message.c_str());
//        for (auto [_, listener]: listeners) {
//            listener(data);
//        }
    }

    int addChangeListener(const std::function<void(int)>& consumer) {
        int id = random();
        while (listeners.find(id) == listeners.end()) { id = random(); }
        listeners[id] = consumer;
        return id;
    }

    void removeChangeListener(int listenerId) {
        listeners.erase(listeners.find(listenerId));
    }
};


auto observable = Observable();
auto setValue = [](JNIEnv *env, jobject data, int number) { observable.setValue(env, data, number); };


#define in(container, element) (container).find(element) != (container).end()

// All classes must inherit from here
class HybridObject {
public:
    // Static Destruction Order Fiasco, also add thread safety
    static decltype(auto) getObjectMap() {
        static std::unordered_map<jobject, HybridObject*> objectMap;
        return objectMap;
    }
};
using ObjectMap = std::unordered_map<jobject, HybridObject*>;


extern "C"
JNIEXPORT void JNICALL
Java_com_myntra_appscore_batcave_interop_HybridObject_destroy(JNIEnv *env, jobject thiz) {
    auto objectMap = HybridObject::getObjectMap();
    if (in(objectMap, thiz)) {
        delete objectMap[thiz];
        objectMap.erase(thiz);
    }
}


JNINativeMethod functionList[] = {
        { "setValue", "(I)V", (void*) (&setValue) }
};


extern "C"
JNIEXPORT void JNICALL
Java_com_myntra_appscore_batcave_interop_NativeObservable_registerHybrid(JNIEnv *env,
                                                                         jobject thiz) {
    auto nativeObservableClass = env->GetObjectClass(thiz);
    env->RegisterNatives(nativeObservableClass, functionList, 1);
}

// Simpler method is present. This is so that we understand reflective access
jstring toJstring(const string &str) {
    jclass stringClass;
    jmethodID constructor;
    jcharArray elemArr;

    stringClass = jni->FindClass("java/lang/String");
    GUARD(stringClass);

    constructor = jni->GetMethodID(stringClass, "<init>", "([C)V");
    GUARD(constructor);

    elemArr = jni->NewCharArray(str.size());
    GUARD(elemArr);

    auto *ptr = reinterpret_cast<const jchar *>(str.c_str());
    jni->SetCharArrayRegion(elemArr, 0, str.size(), ptr);
    return (jstring) jni->NewObject(stringClass, constructor, elemArr);
}




using ConnectorFunction = function<Value(Runtime&, Value)>;
using FunctionMap = unordered_map<string, ConnectorFunction>;

ConnectorFunction helloWorld1 = [](Runtime &runtime, Value value) -> Value {
    string message = "ShibasisPatnaik Hello";
//    jstring jmessage = toJstring(message);
//    string mirrorMessage = jni->GetStringUTFChars(jmessage, nullptr);
    return {
            runtime,
            String::createFromUtf8(runtime, message)
    };
};

decltype(auto) createFromHostFunction(
        Runtime &runtime,
        ConnectorFunction &fn,
        const string &name
) {
    return Function::createFromHostFunction(
            runtime,
            PropNameID::forAscii(runtime, name),
            0,
            [&](Runtime &runtime,
                const Value &thisValue,
                const Value *arguments,
                size_t count
            ) -> Value {
                return fn(runtime, {});
            });
}

struct HelloWorld: HostObject {
    ~HelloWorld() override = default;

    unordered_map<string, function<Value(Runtime&, Value)>> functionMap {
            { "helloWorld", helloWorld1 }
    };

    Value get(Runtime &runtime, const PropNameID &name) override {
        auto key = name.utf8(runtime);

        if (functionMap.find(key) != functionMap.end()) {
            return createFromHostFunction(runtime, functionMap[key], key);
        }

        return {};
    }

    void set(Runtime &runtime, const PropNameID &name, const Value &value) override {}

    std::vector<PropNameID> getPropertyNames(Runtime &rt) override {
        vector<PropNameID> k;
        k.reserve(functionMap.size());
        for (auto [key, value]: functionMap) {
            k.push_back(PropNameID::forAscii(rt, key));
        }
        return k;
    }
};

/*

Should I create a proxy object instead in order to intercept any call from JS ?


 */


extern "C"
JNIEXPORT void JNICALL
Java_com_myntra_appscore_batcave_NativeAdapter_installTurboModules(JNIEnv *env, jobject thiz, jlong pointer) {
    auto _runtime = reinterpret_cast<Runtime *>(pointer);
    LOGV("%s", "SHIBASIS NATIVE CODE")

    if (_runtime) {
        auto &runtime = *_runtime;
        jni = env;
        LOGV("%s", "SHIBASIS NATIVE CODE")

//        auto locationPtr = make_shared<HelloWorld>();
//        auto locationModule = Object::createFromHostObject(runtime, locationPtr);
//        runtime.global().setProperty(runtime, "LocationModule",  locationModule);
        runtime.global().setProperty(runtime, "helloWorld", createFromHostFunction(runtime, helloWorld1, "helloWorld"));
    }
}


