package com.myntra.appscore.reakt.hybrid

class AndroidHostObject {

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
*/





