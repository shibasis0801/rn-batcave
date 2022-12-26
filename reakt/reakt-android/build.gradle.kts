import dev.shibasis.bifrost.android.*
import dev.shibasis.bifrost.*

plugins {
    id("dev.shibasis.bifrost.plugin")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.bytedeco.gradle-javacpp-build") version "1.5.8"
}

android {
    namespace = "com.myntra.appscore.reakt"
    libraryDefaults()
    kotlinOptions {
        jvmTarget = Version.SDK.Java.asString
    }
    libraryVariants.all {

    }
}

dependencies {
    basic()
    api("org.bytedeco:javacpp:1.5.8")
}