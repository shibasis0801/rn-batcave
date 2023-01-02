import groovy.lang.Closure

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

fun include(name: String, path: String? = null) {
    val newName = ":$name"
    settings.include(newName)
    if (path != null) {
        project(newName).projectDir = java.io.File(path)
    }
}

rootProject.name = "tester"

apply(from = file("../node_modules/@react-native-community/cli-platform-android/native_modules.gradle"));
val applyNativeModulesSettingsGradle = extra["applyNativeModulesSettingsGradle"] as Closure<Any>
applyNativeModulesSettingsGradle(settings)

includeBuild("../../bifrost")
include("app")
include("batcave", "../../batcave")
include("reakt-android", "../../reakt/reakt-android")
include("core", "../../kmm/core")
include("database", "../../kmm/database")
include("network", "../../kmm/network")
include("analytics", "../../kmm/analytics")
