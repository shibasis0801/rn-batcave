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
#define GUARD(ptr) if ((ptr) == nullptr) return
#define GUARD_DEFAULT(ptr, fallback) if ((ptr) == nullptr) return fallback


//void installFunctions(Bifrost &bifrost);

auto helloWorld1 = [](Runtime &runtime, Value value) -> Value {
    return {
            runtime,
            String::createFromUtf8(runtime, "ShibasisPatnaik Hello")
    };
};

struct LocationModule: HostObject {
    ~LocationModule() override = default;

    unordered_map<string, function<Value(Runtime&, Value)>> functionMap {
            { "helloWorld", helloWorld1 }
    };


    Value get(Runtime &runtime, const PropNameID &name) override {
        auto key = name.utf8(runtime);

        if (functionMap.find(key) != functionMap.end()) {
            return Function::createFromHostFunction(
                    runtime,
                    PropNameID::forAscii(runtime, key),
                    0,
                    [&](Runtime &runtime,
                        const Value &thisValue,
                        const Value *arguments,
                        size_t count
                    ) -> Value {
                        return functionMap["helloWorld"](runtime, {});
                    });
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

extern "C"
JNIEXPORT void JNICALL
Java_com_myntra_appscore_batcave_NativeAdapter_installTurboModules(JNIEnv *env, jobject thiz, jlong pointer) {
    auto _runtime = reinterpret_cast<Runtime *>(pointer);

    if (_runtime) {
        auto &runtime = *_runtime;

        auto locationPtr = make_shared<LocationModule>();
        auto locationModule = Object::createFromHostObject(runtime, locationPtr);
        runtime.global().setProperty(runtime, "LocationModule",  locationModule);
    }
}

