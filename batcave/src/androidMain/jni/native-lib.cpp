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


auto helloWorld1 = [](Runtime &runtime, Value value) -> Value {
    string message = "ShibasisPatnaik Hello";
    jstring jmessage = toJstring(message);
    string mirrorMessage = jni->GetStringUTFChars(jmessage, nullptr);
    return {
            runtime,
            String::createFromUtf8(runtime, mirrorMessage)
    };
};

using ConnectorFunction = function<Value(Runtime&, Value)>;
using FunctionMap = unordered_map<string, ConnectorFunction>;

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

using NativeFunction = function<Value(Runtime&, Value)>>;
struct NativeObservable: HostObject {

    NativeFunction getValue = [](Runtime &runtime, Value value) -> Value {
        string message = "ShibasisPatnaik Hello";
        jstring jmessage = toJstring(message);
        string mirrorMessage = jni->GetStringUTFChars(jmessage, nullptr);
        return {
                runtime,
                String::createFromUtf8(runtime, mirrorMessage)
        };
    };

    NativeFunction setValue = [](Runtime &runtime)

    unordered_map<string, function<Value(Runtime&, Value)>> functionMap {
            { "getValue",  },
            { "setValue",  }
    };

    Value get(Runtime &runtime, const PropNameID &name) override {
        return HostObject::get(runtime, name);
    }

    void set(Runtime &runtime, const PropNameID &name, const Value &value) override {
        HostObject::set(runtime, name, value);
    }

    vector<PropNameID> getPropertyNames(Runtime &rt) override {
        return HostObject::getPropertyNames(rt);
    }
}

extern "C"
JNIEXPORT void JNICALL
Java_com_myntra_appscore_batcave_NativeAdapter_installTurboModules(JNIEnv *env, jobject thiz, jlong pointer) {
    auto _runtime = reinterpret_cast<Runtime *>(pointer);

    if (_runtime) {
        auto &runtime = *_runtime;
        jni = env;

//        auto locationPtr = make_shared<HelloWorld>();
//        auto locationModule = Object::createFromHostObject(runtime, locationPtr);
//        runtime.global().setProperty(runtime, "LocationModule",  locationModule);



    }
}

