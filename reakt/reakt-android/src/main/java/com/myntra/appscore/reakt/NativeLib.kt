package com.myntra.appscore.reakt

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













