//
// Created by shiba on 24-08-2022.
//

#include "bifrost.h"
#include <vector>
#include <string>
#include <stdexcept>
#include <optional>

#include <jsi/jsi.h>

using std::string;
using std::vector;
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



/*
 * JSI is only safe to call from Main Thread, so beware.
 */
class Bifrost {
public:
    // Not shared_ptr because we don't want a leak. If it becomes null elsewhere, this file becomes no-op
    Runtime *runtime;
    // to avoid * everywhere
    Runtime& getRuntime() const {
        return *runtime;
    }

    explicit Bifrost(Runtime *runtime): runtime(runtime) {}

    struct CallableFunction {
        Runtime *runtime;
        Function *fn;
        CallableFunction(Runtime *runtime, Function *fn): runtime(runtime), fn(fn) {}

        template<typename... Args>
        optional<Value> operator()(Args&& ...args) {
            GUARD_DEFAULT(runtime, {});
            GUARD_DEFAULT(fn, {});

            return fn->call(*runtime, args...);
        }
    };

    struct Constructor {
        Runtime *runtime;
        Function *fn;

        Constructor(Runtime *runtime, Function *fn): runtime(runtime), fn(fn) {}

        template<typename... Args>
        optional<Value> operator()(Args&& ...args) {
            GUARD_DEFAULT(runtime, {});
            GUARD_DEFAULT(fn, {});

            return fn->template callAsConstructor(*runtime, args...);
        }
    };

    template<typename T>
    inline void setProperty(const string &name, T &&property) {
        GUARD(runtime);
        getRuntime().global()
            .setProperty(getRuntime(), name.c_str(), std::forward<T>(property));
    }


    inline Value getProperty(const string &name) const {
        return getRuntime().global()
            .getProperty(getRuntime(), name.c_str());
    }

    using HostFunctionType1 = std::function<
            Value(Runtime& rt, const Value* args, size_t count)>;

    inline void newFunction(
            const string &name,
            int argumentCount,
            HostFunctionType &&function
    ) {
        GUARD(runtime);
        auto jsiFunction = Function::createFromHostFunction(
                getRuntime(),
                PropNameID::forAscii(getRuntime(), name),
                argumentCount,
                std::move(function)
        );
        setProperty(name, std::move(jsiFunction));
    }

    inline optional<String> newString(const string &cppString) {
        GUARD_DEFAULT(runtime, {});
        return String::createFromUtf8(getRuntime(), cppString);
    }

    template<typename T>
    inline optional<Value> newValue(const T &&data) {
        GUARD_DEFAULT(runtime, {});
        return Value(getRuntime(), data);
    }

    inline optional<Object> asObject(const Value &value) {
        GUARD_DEFAULT(runtime, {});
        if (value.isObject())
            return value.asObject(getRuntime());
        return {};
    }


    inline optional<Function> asFunction(const Value &value) {
        GUARD_DEFAULT(runtime, {});
        auto fn = asObject(value);
        if (fn && fn->isFunction(getRuntime())) {
            return fn->asFunction(getRuntime());
        }
        return {};
    }
    inline optional<CallableFunction> asCallableFunction(const Value &value) {
        GUARD_DEFAULT(runtime, {});
        auto fn = asFunction(value);
        if (fn) {
            return CallableFunction(runtime, &*fn);
        }
        return {};
    }

    inline optional<Constructor> asConstructor(optional<Function> &&fn) {
        GUARD_DEFAULT(runtime, {});
        if (fn) {
            return Constructor(runtime, &*fn);
        }
        return {};
    }

    inline optional<Function> getPropertyAsFunction(const string &name) {
        return asFunction(getProperty(name));
    }
};



class TestObject: HostObject {
    /*
     * Create a map of functions here and call them
     */

    Value get(Runtime &runtime, const PropNameID &name) override {
        return HostObject::get(runtime, name);
    }

    void set(Runtime &runtime, const PropNameID &name, const Value &value) override {
        HostObject::set(runtime, name, value);
    }

    vector<PropNameID> getPropertyNames(Runtime &rt) override {
        return HostObject::getPropertyNames(rt);
    }

    ~TestObject() override {

    }
};


void installFunctions(Runtime *runtime) {
    Bifrost bifrost(runtime);
    // Create a fluent API from this
    auto Promise = bifrost.asConstructor(bifrost.getPropertyAsFunction("Promise"));

    if(Promise) {

    }
    bifrost.newFunction("helloWorld", 0,
                        [&] (
                                Runtime &runtime,
                                const Value &thisValue,
                                const Value *arguments,
                                size_t count
                        ) -> Value {
                            auto str = bifrost.newString("Hello World");
                            if (str)
                                return {
                                        runtime,
                                        str.value()
                                };

                            return {};
                        }
    );
}
