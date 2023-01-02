import dev.shibasis.bifrost.android.droid
import dev.shibasis.bifrost.android.libraryDefaults

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
    id("maven-publish")
    id("dev.shibasis.bifrost.plugin")
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
        binaries.executable()
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
            }
        }

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
                implementation("com.squareup.sqldelight:runtime:1.5.4")
                implementation("io.insert-koin:koin-core:3.2.0")
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
                implementation(devNpm("copy-webpack-plugin", "11.0.0"))
                implementation("com.squareup.sqldelight:sqljs-driver:1.5.4")
//                implementation(npm("dexie", "3.2.2", true))
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
