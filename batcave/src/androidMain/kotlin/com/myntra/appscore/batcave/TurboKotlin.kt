package com.myntra.appscore.batcave

import android.view.View
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.*
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.turbomodule.core.interfaces.TurboModule
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager


const val TURBO_KOTLIN = "TurboKotlin"

@DoNotStrip
@ReactModule(name = TURBO_KOTLIN)
class TurboKotlin(
    reactApplicationContext: ReactApplicationContext
): ReactContextBaseJavaModule(reactApplicationContext) {
    override fun getName() = TURBO_KOTLIN
    private val cppAdapter = CppAdapter()

    override fun initialize() {
        super.initialize()
        val pointer = reactApplicationContext.javaScriptContextHolder.get()
        if (pointer != 0L)
            cppAdapter.nativeInstall(pointer)
    }
}

class TurboKotlinPackage: ReactPackage {
    override fun createNativeModules(
        reactContext: ReactApplicationContext
    ) = mutableListOf<NativeModule> (
        TurboKotlin(reactContext)
    )

    override fun createViewManagers(
        reactContext: ReactApplicationContext
    ) = mutableListOf<ViewManager<View, ReactShadowNode<*>>>()
}
