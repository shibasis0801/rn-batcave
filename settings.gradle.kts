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
includeBuild("tester/android")

include("batcave")
include("reakt", "./reakt/reakt-android")
include("core", "./kmm/core")
include("database", "./kmm/database")
include("network", "./kmm/network")
include("analytics", "./kmm/analytics")
