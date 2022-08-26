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
}

group = "com.myntra.appscore"
version = "1.0-SNAPSHOT"

kotlin {
    droid()
    ios() {}
    js(IR) {
        moduleName = "batcave"
        browser {
            webpackTask {
                outputFileName = "batcave.js"
                output.libraryTarget = "commonjs2"
            }
        }
        binaries.executable()
    }

    cocoapods {
        ios.deploymentTarget = "14.1"
        podfile = project.file("../tester/ios/Podfile")
        framework {
            baseName = "batcave"
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }

        val commonMain by getting {
            commonRequire()
        }
        val commonTest by getting {
            testRequire()
        }
        val androidMain by getting {
            androidRequire {
                api(project(":core"))
                api(project(":network"))
                api(project(":database"))
                api(project(":analytics"))
                api("com.facebook.react:react-native:+")
            }
        }
        val iosMain by getting {
            dependencies {

            }
        }
        val jsMain by getting {
            webRequire {
                implementation(devNpm("copy-webpack-plugin", "11.0.0"))
            }
        }

    }
}


android {
    kmmAndroidApply()
}
