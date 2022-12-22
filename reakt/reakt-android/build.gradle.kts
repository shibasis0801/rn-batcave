import dev.shibasis.bifrost.android.*
import dev.shibasis.bifrost.*

plugins {
    id("dev.shibasis.bifrost.plugin")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.myntra.appscore.reakt"
    libraryDefaults()
    kotlinOptions {
        jvmTarget = Version.SDK.Java.asString
    }
}

dependencies {
    basic()
}