import dev.shibasis.bifrost.web.*
import dev.shibasis.bifrost.android.*
import dev.shibasis.bifrost.common.*
import dev.shibasis.bifrost.*

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
    id("maven-publish")
    id("dev.shibasis.bifrost.plugin")
    kotlin("plugin.serialization")
}

group = "com.myntra.appscore"
version = "1.0-SNAPSHOT"

kotlin {
    droid()
    ios() {}
    js(IR) {
        moduleName = "core"
        browser {
            webpackTask {
                outputFileName = "core.js"
                output.libraryTarget = "commonjs2"
            }
        }
        binaries.executable()
    }

    cocoapods {
        ios.deploymentTarget = "14.1"
        podfile = project.file("../tester/ios/Podfile")
        framework {
            baseName = "core"
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }

        val commonMain by getting {
            commonRequire {
                serialization()
                coroutines()
            }
        }
        val commonTest by getting {
            testRequire()
        }
        val androidMain by getting {
            androidRequire {
                basic()
                androidCoroutines()
            }
        }
        val iosMain by getting {
            dependencies {

            }
        }
        val jsMain by getting {
            webRequire {
                implementation(devNpm("copy-webpack-plugin", "11.0.0"))
                webCoroutines()
            }
        }

    }
}


android {
    kmmAndroidApply()
}
