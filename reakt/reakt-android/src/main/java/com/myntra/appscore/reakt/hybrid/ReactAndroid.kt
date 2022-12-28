package com.myntra.appscore.reakt.hybrid

class ReactAndroid {
    external fun installTurboModules(reactPointer: Long)
    companion object {
        init {
            System.loadLibrary("batcave")
        }
    }
}

