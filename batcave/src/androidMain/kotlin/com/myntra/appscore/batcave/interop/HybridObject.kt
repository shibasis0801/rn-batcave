package com.myntra.appscore.batcave.interop

import java.io.Closeable

abstract class HybridObject: Closeable {
    init { initNative() }
    abstract fun initNative()

    override fun close() { destroy() }
    private external fun destroy()
}

class NativeObservable: HybridObject() {
    override fun initNative() {

    }

    external fun registerHybrid()
    external fun setValue(value: Int)
}