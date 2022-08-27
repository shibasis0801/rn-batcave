package com.myntra.appscore.batcave

import android.view.View
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.*
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager


const val TURBO_KOTLIN = "TurboKotlin"
@ReactModule(name = TURBO_KOTLIN)
class TurboKotlin(
    reactApplicationContext: ReactApplicationContext
): ReactContextBaseJavaModule(reactApplicationContext) {
    override fun getName() = TURBO_KOTLIN
    val cppAdapter = CppAdapter()

    override fun initialize() {
        super.initialize()
    }

    fun installReact(reactContext: JavaScriptContextHolder) {
        val pointer = reactContext.get()
        if (pointer != 0L)
            cppAdapter.nativeInstall(pointer)
    }

}

class TurboKotlinPackage: ReactPackage {
    override fun createNativeModules(
        reactContext: ReactApplicationContext
    ): MutableList<NativeModule> {

    }

    override fun createViewManagers(reactContext: ReactApplicationContext): MutableList<ViewManager<View, ReactShadowNode<*>>> {
        TODO("Not yet implemented")
    }
}