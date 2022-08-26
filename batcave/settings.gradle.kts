pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            when(requested.id.namespace) {
                "com.android" -> useModule("com.android.tools.build:gradle:${requested.version}")
                "com.google.gms" -> useModule("com.google.gms:${requested.id.name}:${requested.version}")
                "kotlinx-serialization"-> useModule("org.jetbrains.kotlinx:kotlinx-gradle-serialization-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "batcave"
include("batcave")
includeBuild("android")
