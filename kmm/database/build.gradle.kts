import dev.shibasis.bifrost.android.*
import dev.shibasis.bifrost.web.*
import dev.shibasis.bifrost.common.*


plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
    id("maven-publish")
    id("dev.shibasis.bifrost.plugin")
    id("dev.petuska.npm.publish") version "3.2.0"
}

group = "com.myntra.appscore"
version = "1.0-SNAPSHOT"

kotlin {
    droid()
    ios() {
        binaries.all {
            linkerOpts("sqlite3")
        }
    }

    js(IR) {
        moduleName = "database"
        compilations["main"].packageJson {

        }
        browser {
            distribution {
                directory = File("$projectDir/database")
            }
            webpackTask {
                outputFileName = "database.js"
                output.libraryTarget = "commonjs2"
            }
        }
        binaries.library()
    }

    cocoapods {
        summary = "Some description for the database Module"
        homepage = "Link to the database Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../../tester/ios/Podfile")
        framework {
            baseName = "database"
        }

    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
                optIn("DelicateCoroutinesApi")
            }
        }

        val commonMain by getting {
            dependencies {
                serialization()
                coroutines()
                implementation("com.squareup.sqldelight:runtime:1.5.4")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:android-driver:1.5.4")
                implementation("com.squareup.okhttp3:okhttp:4.10.0")
//                implementation("androidx.datastore:datastore-preferences:1.0.0")
                // Bad API ^^^
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:native-driver:1.5.4")
            }
        }
        val jsMain by getting {
            dependencies {
                webBasic()
                webCoroutines()
                implementation("com.juul.indexeddb:core:0.5.0")
                implementation("com.squareup.sqldelight:sqljs-driver:1.5.4") // Dropped in DCE, only present for compilation without another sourceset
                implementation(devNpm("copy-webpack-plugin", "11.0.0"))
//                implementation(npm("idb", "7.1.1"))
            }
        }

    }
}

sqldelight {
    database("MainDatabase") {
        packageName = "com.myntra.appscore"
    }
}


android {
    libraryDefaults()
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
