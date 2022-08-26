package com.myntra.appscore.batcave

class CppAdapter {
    external fun nativeInstall(pointer: Long)
    companion object {
        init {
            System.loadLibrary("batcave")
        }
    }
}
