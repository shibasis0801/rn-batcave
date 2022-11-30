package com.myntra.appscore.batcave.bridge

import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableNativeArray
import com.facebook.react.bridge.WritableArray
import com.facebook.react.bridge.WritableNativeArray
import com.facebook.react.module.annotations.ReactModule

const val BRIDGE_MODULE = "LegacyBridge"

@DoNotStrip
@ReactModule(name = BRIDGE_MODULE)
class BridgeModule(reactContext: ReactApplicationContext): ReactContextBaseJavaModule(reactContext) {
    override fun getName() = BRIDGE_MODULE

    @ReactMethod
    fun helloWorld(message: String, promise: Promise) {
        println("SHIBASIS " + message)
        "ANDROID SAYS HELLO".toReact(promise)
    }

    @ReactMethod
    fun testQuery(query: String, promise: Promise) = listOf(
        "Shibasis",
        "Patnaik",
        "JSI",
        "KMM",
        "React",
        "Compose",
        "Protobuf"
    ).toReact(promise)

}

object Transformers {

}

fun String.toReact(promise: Promise) = promise.resolve(this)

fun<T> Iterable<T>.toReact(promise: Promise) = WritableNativeArray().apply {
    forEach {
        when (it) {
            is String -> pushString(it)
            is Int -> pushInt(it)
            is Double -> pushDouble(it)
            else -> throw Error("Not supported, please add your custom transformer for your class")
        }
    }
}.run { promise.resolve(this) }
