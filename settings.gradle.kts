
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

fun include(name: String, path: String? = null) {
    settings.include(name)
    if (path != null) {
        project(name).projectDir = File(path)
    }
}

includeBuild("bifrost")
includeBuild("tester/android")

include("batcave")
//include("core", "kmm/core")
//include("database", "kmm/database")
//include("network", "kmm/network")
//include("analytics", "kmm/analytics")
