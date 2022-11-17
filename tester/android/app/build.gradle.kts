import dev.shibasis.bifrost.web.*
import dev.shibasis.bifrost.android.*
import dev.shibasis.bifrost.common.*
import dev.shibasis.bifrost.*
import com.android.build.api.variant.FilterConfiguration.FilterType.ABI
import groovy.lang.Closure

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dev.shibasis.bifrost.plugin")
}

val enableHermes = true
project.extra.apply {
    set("react", mapOf(
        "enableHermes" to enableHermes
    ))
}

apply(from = file("../../node_modules/react-native/react.gradle"))

/**
 * Set this to true to create two separate APKs instead of one:
 *   - An APK that only works on ARM devices
 *   - An APK that only works on x86 devices
 * The advantage is the size of the APK is reduced by about 4MB.
 * Upload all the APKs to the Play Store and people will download
 * the correct one based on the CPU architecture of their device.
 */
val enableSeparateBuildPerCPUArchitecture = true

/**
 * Run Proguard to shrink the Java bytecode in release builds.
 */
val enableProguardInReleaseBuilds = false

/**
 * Whether to enable the Hermes VM.
 *
 * This should be set on project.ext.react and that value will be read here. If it is not set
 * on project.ext.react, JavaScript will not be compiled to Hermes Bytecode
 * and the benefits of using Hermes will therefore be sharply reduced.
 */


/**
 * Architectures to build native code for in debug.
 */
//val nativeArchitectures = project.properties["reactNativeDebugArchitectures"]
val abiCodes = mapOf(
    "armeabi-v7a" to 1,
    "x86" to 2,
    "arm64-v8a" to 3,
    "x86_64" to 4
)

android {
    ndkVersion = Version.SDK.ndkVersion
    compileSdk = Version.SDK.compileSdk

    defaultConfig {
        applicationId = "com.myntra.appscore.tester"
        minSdk = Version.SDK.minSdk
        targetSdk = Version.SDK.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    packagingOptions {
        val libraries = listOf("libc++_shared.so", "libreactnativejni.so")
        val paths = mutableListOf<String>()
        abiCodes.keys.forEach { abi ->
            libraries.forEach { library ->
                paths.add("lib/$abi/$library")
            }
        }
        resources.pickFirsts.addAll(paths)
    }
    splits {
        abi {
            reset()
            isEnable = true
            isUniversalApk = false
            include(*abiCodes.keys.toTypedArray())
        }
    }
    signingConfigs {
        getByName("debug") {
            storeFile = file("debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }
    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
            ndk {
//                abiFilters.addAll(abiCodes.keys)
            }


        }

        release {
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    // For each APK output variant, override versionCode with a combination of
    // abiCodes * 1000 + variant.versionCode. In this example, variant.versionCode
    // is equal to defaultConfig.versionCode. If you configure product flavors that
    // define their own versionCode, variant.versionCode uses that value instead.
    androidComponents {
        onVariants { variant ->
            // For each separate APK per architecture, set a unique version code as described here:
            // https://developer.android.com/studio/build/configure-apk-splits.html
            // Example: versionCode 1 will generate 1001 for armeabi-v7a, 1002 for x86, etc.

            // Assigns a different version code for each output APK
            // other than the universal APK.
            variant.outputs.forEach { output ->
                val name = output.filters.find { it.filterType == ABI }?.identifier

                // Stores the value of abiCodes that is associated with the ABI for this variant.
                val baseAbiCode = abiCodes[name]
                // Because abiCodes.get() returns null for ABIs that are not mapped by ext.abiCodes,
                // the following code does not override the version code for universal APKs.
                // However, because we want universal APKs to have the lowest version code,
                // this outcome is desirable.
                if (baseAbiCode != null) {
                    // Assigns the new version code to output.versionCode, which changes the version code
                    // for only the output APK, not for the variant itself.
                    output.versionCode.set(baseAbiCode * 1000 + (output.versionCode.get() ?: 0))
                }
            }
        }
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
    basic()
    //noinspection GradleDynamicVersion
    implementation("com.facebook.react:react-native:+")

    api(project(":batcave"))
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.0.0")

//    flipper()

    val hermesPath= "../../node_modules/hermes-engine/android/"
    debugImplementation(files(hermesPath + "hermes-debug.aar"))
    releaseImplementation(files(hermesPath + "hermes-release.aar"))
}

//// Run this once to be able to run the application with BUCK
//// puts all compile dependencies into folder libs for BUCK to use
//task copyDownloadableDepsToLibs(type: Copy) {
//    from configurations.implementation
//    into "libs"
//}

apply(from = file("../../node_modules/@react-native-community/cli-platform-android/native_modules.gradle"));
val applyNativeModulesAppBuildGradle = extra["applyNativeModulesAppBuildGradle"] as Closure<Any>
applyNativeModulesAppBuildGradle(project)
