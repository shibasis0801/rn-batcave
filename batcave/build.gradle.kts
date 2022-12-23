import dev.shibasis.bifrost.web.*
import dev.shibasis.bifrost.android.*
import dev.shibasis.bifrost.common.*
import dev.shibasis.bifrost.*
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

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
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    val xcf = XCFramework()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            embedBitcode("disable")
            xcf.add(this)
        }
    }
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
        pod("reakt") {
            version = "1.0"
            source = path(project.file("../reakt/reakt-darwin"))
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
            }

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
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

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
    kmmAndroidApply(file("./CMakeLists.txt"))
}
