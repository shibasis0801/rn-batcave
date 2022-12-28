package com.myntra.appscore.reakt

import com.myntra.appscore.reakt.generated.NativeLibrary
import org.bytedeco.javacpp.annotation.Namespace

class NativeLib {

    /**
     * A native method that is implemented by the 'reakt' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'reakt' library on application startup.
        init {
            System.loadLibrary("reakt")
        }
    }
}


/*
JavaCPP based Hybrid Class
 */
class AndroidHostObject {
    fun test() = NativeLibrary.NativeClass().run {
        set_property("sanu")
        _property.string
    }
}


/*
Hybrid class for state
 */
@Namespace("Test")
class NativeState {

}


/*

How to create a Hybrid class ?

> Create base class with virtual functions in C++ common, example NativeState
> Create AndroidNativeState and DarwinNativeState classes
> AndroidNativeState
    > Use JavaCPP to separate JVM and NDK code
    > Can't pass functions, so should have wrapper code
> DarwinNativeState
    > Should have protocols which kotlin will extend
    > Can pass functions, so should be handled well
> NativeState
    > Use expect/actual to map AndroidNativeState and DarwinNativeState to one class
    > You should be able to now pass these classes into C++

Create a KMM wrapper for these

JavaCPP is 500kb before DCE
*/
















