/*
#include <jni.h>
#include <string>
#include <functional>
#include <unordered_map>
#include <iostream>
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
auto setValue = [](int data) { observable.setValue(data); };


struct BifrostObservable {

};


JNINativeMethod functionList[] = {
        { "setValue", "(I)V", (void*) (&setValue) }
};




#define in(container, element) (container).find(element) != (container).end()
// All classes must inherit from here
class HybridObject {
public:
    static std::unordered_map<jobject, HybridObject*> objectMap;

};



extern "C"
JNIEXPORT void JNICALL
Java_com_example_myapplication_HybridObject_destroy(JNIEnv *env, jobject thiz) {
auto &objectMap = HybridObject::objectMap;
if (in(objectMap, thiz)) {
delete objectMap[thiz];
objectMap.erase(thiz);
}
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myapplication_HybridObject_initNative(
        JNIEnv *env,
jobject thiz
) {
auto nativeObservableClass = env->GetObjectClass(thiz);
env->RegisterNatives(nativeObservableClass, functionList, 1);
}


 package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.io.Closeable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val counter = MutableStateFlow(0)

    val counterNative = NativeObservable(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method

        lifecycleScope.launch {
            counter.collect {
                counterNative.setValue(it)
                binding.sampleText.text = getStringFromNative(counter).toString()
            }
        }

        binding.sampleText.setOnClickListener {
            counter.value += 1
        }
    }

    external fun getStringFromNative(counter: MutableStateFlow<Int>): Int


    companion object {
        // Used to load the 'myapplication' library on application startup.
        init {
            System.loadLibrary("myapplication")
        }
    }
}

Since JVM has garbage collection, if we don't remove them from native memory
Then we can have dangling references resulting in memory leaks or crashes
abstract class HybridObject: Closeable {
    init { initNative() }
private external fun initNative()

    override fun close() { destroy() }
private external fun destroy()
}

        data class Test(val name: String)

abstract class NativeObservable(initialValue: Int): HybridObject() {
    fun t(test: Test) {

    }
}

class NativeMutableState(initialValue: Int) {


external fun setValue(number: Int)
}

*/