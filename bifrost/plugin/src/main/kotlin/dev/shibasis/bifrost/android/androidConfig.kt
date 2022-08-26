package dev.shibasis.bifrost.android
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.android.build.gradle.LibraryExtension
import dev.shibasis.bifrost.Version
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinAndroidTarget
import java.io.File
import java.nio.file.Paths

/*
Needs a lot of improvements
Right now it just hides things
 */
@Suppress("UnstableApiUsage")
fun LibraryExtension.kmmAndroidApply() {
    compileSdk = Version.SDK.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Version.SDK.minSdk
        targetSdk = Version.SDK.targetSdk
    }
    compileOptions {
        sourceCompatibility = Version.SDK.Java.asEnum
        targetCompatibility = Version.SDK.Java.asEnum
    }
}

@Suppress("UnstableApiUsage")
fun BaseAppModuleExtension.androidApply(appID: String, useNDK: Boolean = false) {
    compileSdk = Version.SDK.compileSdk
//    if (useNDK)
//        ndkVersion = Version.SDK.ndkVersion
    defaultConfig {
        applicationId = appID
        minSdk = Version.SDK.minSdk
        targetSdk = Version.SDK.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        if (useNDK)
            externalNativeBuild {
                cmake {
                    cFlags.addAll(listOf("-Wall", "-Werror", "-fexceptions", "-frtti", "-DWITH_INSPECTOR=1"))
                    arguments.add("-DCMAKE_VERBOSE_MAKEFILE=1")
                    cppFlags.add("-std=c++17")
                }
            }
    }

    if (useNDK)
        externalNativeBuild {
            cmake {
                path = File("./CMakeLists.txt")
                // pin cmake version to support M1 machines
                version = "3.22.1"
            }
        }

    compileOptions {
        sourceCompatibility = Version.SDK.Java.asEnum
        targetCompatibility = Version.SDK.Java.asEnum
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.Compose
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

@Suppress("UnstableApiUsage")
fun LibraryExtension.libraryDefaults(
    cmakeLists: File? = null
) {
    val useNDK = cmakeLists != null
    compileSdk = Version.SDK.compileSdk
    println("SHIBASIS $useNDK")
    if (useNDK)
        ndkVersion = Version.SDK.ndkVersion
    defaultConfig {
        minSdk = Version.SDK.minSdk
        targetSdk = Version.SDK.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        if (useNDK)
            externalNativeBuild {
                cmake {
                    cFlags.addAll(listOf("-Wall", "-Werror", "-fexceptions", "-frtti", "-DWITH_INSPECTOR=1"))
                    arguments.add("-DCMAKE_VERBOSE_MAKEFILE=1")
                    cppFlags.add("-std=c++17")
                }
            }
    }

    val library = this
    if (useNDK)
        externalNativeBuild {
            cmake {
                path = cmakeLists
                // pin cmake version to support M1 machines
                version = "3.22.1"
            }
        }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = Version.SDK.Java.asEnum
        targetCompatibility = Version.SDK.Java.asEnum
    }
}

@Suppress("UnstableApiUsage")
fun KotlinMultiplatformExtension.droid(configure: KotlinAndroidTarget.() -> Unit = {}) {
    android {
        publishLibraryVariants("release", "debug")
        compilations.all {
            kotlinOptions.jvmTarget = Version.SDK.Java.asString
        }
        configure()
    }
}

