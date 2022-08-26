import dev.shibasis.bifrost.web.*
import dev.shibasis.bifrost.android.*
import dev.shibasis.bifrost.common.*
import dev.shibasis.bifrost.*

plugins {
    id("dev.shibasis.bifrost.plugin")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

group = "com.myntra.appscore"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
}

android {
    libraryDefaults()
    kotlinOptions {
        jvmTarget = Version.SDK.Java.asString
    }
}

dependencies {
    basic()
}
