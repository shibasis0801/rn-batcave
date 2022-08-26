package com.myntra.appscore.batcave

class CppAdapter {
    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("batcave")
        }
    }
}
