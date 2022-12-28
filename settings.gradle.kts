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
        project(newName).projectDir = File(path)
    }
}

includeBuild("bifrost")

include("reakt-android", "./reakt/reakt-android")
include("core", "./kmm/core")
include("database", "./kmm/database")
include("network", "./kmm/network")
include("analytics", "./kmm/analytics")
include("batcave")

//includeBuild("tester/android")