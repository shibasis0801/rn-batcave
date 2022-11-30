package com.myntra.appscore.batcave

import android.util.Log
import android.view.View
import android.widget.Toast
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.*
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager
import com.myntra.appscore.batcave.bridge.BridgeModule

const val TURBO_KOTLIN = "TurboKotlin"

@DoNotStrip
@ReactModule(name = TURBO_KOTLIN)
class TurboKotlin(
    reactApplicationContext: ReactApplicationContext
): ReactContextBaseJavaModule(reactApplicationContext) {
    override fun getName() = TURBO_KOTLIN
    private val cppAdapter = NativeAdapter()

    override fun initialize() {
        super.initialize()
        val pointer = reactApplicationContext.javaScriptContextHolder.get()
        Log.d("", "SHIBASIS ADAPTER CODE")
        Log.d("SHIBASIS", getSchemaString(Person::class))
        val mirror = ProtobufSerializer.fromBytes<Person>(ProtobufSerializer.getBytes(dataForTransferOverJSI))

        Log.d("SHIBASIS", if (mirror == dataForTransferOverJSI) "Working Protobuf" else "not equal")
        if (pointer != 0L){
            Log.d("", "SHIBASIS ADAPTER CODE")
            cppAdapter.installTurboModules(pointer)
        }

    }
}

class TurboKotlinPackage: ReactPackage {
    override fun createNativeModules(
        reactContext: ReactApplicationContext
    ) = mutableListOf<NativeModule> (
        TurboKotlin(reactContext),
        BridgeModule(reactContext)
    )

    override fun createViewManagers(
        reactContext: ReactApplicationContext
    ) = mutableListOf<ViewManager<View, ReactShadowNode<*>>>()
}
