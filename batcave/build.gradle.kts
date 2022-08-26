import dev.shibasis.bifrost.android.droid
import dev.shibasis.bifrost.android.kmmAndroidApply

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
        moduleName = "database"
        browser {
            distribution {
                directory = File("$projectDir/batcave")
            }
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
            dependencies {

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {

            }
        }
        val iosMain by getting {
            dependencies {

            }
        }
        val jsMain by getting {
            dependencies {
                implementation(devNpm("copy-webpack-plugin", "11.0.0"))
            }
        }

    }
}


android {
    kmmAndroidApply()
}

dependencies {
    var koinEnabledConfigs = listOf(
        "kspCommonMainMetadata",
        "kspAndroid",
        "kspIosArm64",
        "kspIosX64",
        "kspJs"
    )

//    koinEnabledConfigs
//        .forEach {
//            println(it)
//            add(it, "io.insert-koin:koin-ksp-compiler:1.0.1")
//        }
}
