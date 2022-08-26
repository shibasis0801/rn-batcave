includeBuild("bifrost")
includeBuild("batcave")
fun include(name: String, path: String? = null) {
    settings.include(name)
    if (path != null) {
        project(name).projectDir = File(path)
    }
}
