package dev.shibasis.bifrost

import org.gradle.api.JavaVersion

object Version {
    object SDK {
        const val minSdk = 24
        const val compileSdk = 32
        const val targetSdk = 32
        const val ndkVersion = "25.0.8775105"

        const val Kotlin = "1.7.10"
        object Java {
            val asEnum = JavaVersion.VERSION_11
            val asString = "11"
        }
    }

    // Android
    const val Compose = "1.2.0"
    const val Activity = "1.3.1"
    const val Fragment = "1.3.6"
    const val Lifecycle = "2.4.0"
    const val Navigation = "2.3.2"

    // Web
    const val KotlinJSWrappers = "1.0.0-pre.369"

    // Network
    const val SQLDelight = "1.5.3"
    const val Room = "2.4.2"
    const val OkHttp = "4.9.0"
    const val WorkManager = "2.7.0"
    const val Klaxon = "5.5"

    // Image
    const val Coil = "2.0.0-rc03"


    // Cloud
    const val Firebase = "30.3.0"

    // Android Camera
    const val CameraX = "1.1.0"
    const val CameraView = "1.1.0"


    // KMM Async
    const val Coroutines = "1.6.1"

    // DevTools
    const val Flipper = "0.138.0"
    const val LeakCanary = "2.8.1"
    const val SoLoader = "0.10.1"

    const val Koin = "3.2.0"
    const val KoinAnnotations = "1.0.1"
}
