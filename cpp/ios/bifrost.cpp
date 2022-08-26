//
// Created by shiba on 24-08-2022.
//

#include "bifrost.h"
#include <vector>
#include <string>
#include <stdexcept>

#include <jsi/jsi.h>

using std::string;
using std::vector;
using std::make_shared;
using std::shared_ptr;
using std::function;
using namespace facebook::jsi;

using PlatformFunction = function<
        Value(const vector<shared_ptr<Value>> &arguments)>;
/*
 * Make thread safe, and handle destruction
 */
class Bifrost {
    Runtime &runtime;

public:
    // Make thread / destroy safe
    Runtime& getRuntime() {
        return runtime;
    }

    Bifrost(Runtime &runtime): runtime(runtime) {}

    template<typename T>
    void setProperty(const string &name, T &&property) {
        getRuntime().global().setProperty(getRuntime(), name.c_str(), std::forward<T>(property));
    }

    void newFunction(
            const string &name,
            int argumentCount,
            HostFunctionType &&function
    ) {
        auto jsiFunction = Function::createFromHostFunction(
                getRuntime(),
                PropNameID::forAscii(getRuntime(), name),
                argumentCount,
                std::move(function)
        );
        setProperty(name, std::move(jsiFunction));
    }

    void newFunction(
            const string &name,
            int argumentCount,
            PlatformFunction &&platformFunction
    ) {
        newFunction(
                name,
                argumentCount,
                [=] (
                        Runtime &runtime,
                        const Value &thisValue,
                        const Value *arguments,
                        size_t count
                ) -> Value {
                    vector<std::shared_ptr<Value>> args;
                    for (int i = 0; i < count; ++i) {
                        args.emplace_back(std::make_shared<Value>(runtime, arguments[i]));
                    }
                    return platformFunction(args);
                });
    }

    String newString(const string &cppString) {
        return String::createFromUtf8(getRuntime(), cppString);
    }

    template<typename T>
    Value newValue(T data) {
        return Value(getRuntime(), data);
    }
};


class BifrostValue {
public:
    Runtime &runtime;
    const shared_ptr<Value> value;
    BifrostValue(
            Runtime &runtime,
            Value &&value
    ): runtime(runtime), value(make_shared<Value>(runtime, value)) {}

    template<typename T>
    static BifrostValue newValue(
            Runtime &runtime,
            T data
    ) {
        return {
                runtime,
                std::move(Value(runtime, data))
        };
    }

    bool isObject() { return value->isObject(); }
    bool isFunction() { return isObject() && value->asObject(runtime).isFunction(runtime); }


    Object asObject() {
        if (value->isObject())
            return value->asObject(runtime);
        else
            throw std::invalid_argument("Not an object");
    }

    Function asFunction() {
        if (value->isObject())
            return asObject().asFunction(runtime);
        else
            throw std::invalid_argument("Not a function");
    }
};

class BifrostFunction: BifrostValue {
    BifrostFunction(Runtime &runtime,Value functionObject): BifrostValue(runtime, functionObject) {
        if (!isFunction()) {
            throw std::invalid_argument("Not a function, can only wrap functions");
        }
    }

    template<typename... Args>
    Value operator()(Args&& ...args) {
        return asFunction().call(runtime, args...);
    }
};



void installFunctions(Runtime &runtime) {
    Bifrost bifrost(runtime);
    bifrost.newFunction("helloWorld", 0, std::move([&] (
                vector<shared_ptr<Value>> &args
            ) -> Value {
                Value value = BifrostValue::newValue<string>(runtime, "Hello World").value.get();
                return bifrost.newValue(
                        bifrost.newString("Hello World")
                );
            }
    ));
}
