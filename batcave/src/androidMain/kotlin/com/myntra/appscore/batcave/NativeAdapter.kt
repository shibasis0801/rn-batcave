package com.myntra.appscore.batcave

class NativeAdapter {
    external fun installTurboModules(reactPointer: Long)
    companion object {
        init {
            System.loadLibrary("batcave")
        }
    }
}
