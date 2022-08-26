package com.myntra.appscore.batcave

import com.facebook.react.bridge.*


class TurboKotlin(
    reactApplicationContext: ReactApplicationContext
): ReactContextBaseJavaModule(reactApplicationContext) {
    override fun getName() = "TurboKotlin"
    val cppAdapter = CppAdapter()

    fun installReact(reactContext: JavaScriptContextHolder) {
        val pointer = reactContext.get()
        if (pointer != 0L)
            cppAdapter.nativeInstall(pointer)
    }

}

class TurboKotlinPackage: JSIModulePackage {
    override fun getJSIModules(
        reactApplicationContext: ReactApplicationContext,
        jsContext: JavaScriptContextHolder
    ): MutableList<JSIModuleSpec<JSIModule>> {

        reactApplicationContext
            .getNativeModule(TurboKotlin::class.java)
            ?.installReact(jsContext)

        // Why send empty ?
        return mutableListOf()
    }
}