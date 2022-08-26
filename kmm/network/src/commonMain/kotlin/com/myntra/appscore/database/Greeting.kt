package com.myntra.appscore.database

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
fun helloWorld(message: String) = "Hello $message"

@JsExport
class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
