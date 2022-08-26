#include "jsi.h"
#include <string>
#include <jni.h>
using namespace facebook::jsi;

//void installFunctions(Bifrost &bifrost);

extern "C"
JNIEXPORT void JNICALL
Java_com_myntra_appscore_batcave_CppAdapter_nativeInstall(JNIEnv *env, jobject thiz, jlong pointer) {
    auto _runtime = reinterpret_cast<Runtime *>(pointer);
    if (_runtime) {
        auto &runtime = *_runtime;
        auto helloWorld = Function::createFromHostFunction(
                runtime,
                PropNameID::forAscii(runtime, "helloWorld"),
                0,
                [&](Runtime &runtime,
                    const Value &thisValue,
                    const Value *arguments,
                    size_t count
                ) -> Value {
                    return Value(
                        runtime,
                        String::createFromUtf8(runtime, "helloWorld")
                    );
                });
        runtime.global().setProperty(runtime, "helloWorld", std::move(helloWorld));
    }
}

//
//void installFunctions(Bifrost &bifrost) {
//    auto helloWorld = [&] (const vector<shared_ptr<Value>> &args) -> Value {
//        return bifrost.newValue(
//                bifrost.newString("Hello From Turbo Kotlin")
//        );
//    };
//
//    bifrost.newFunction("helloWorld", 0, std::move(helloWorld));
//}
