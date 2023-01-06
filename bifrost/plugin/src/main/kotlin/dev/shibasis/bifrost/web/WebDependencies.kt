package dev.shibasis.bifrost.web

import dev.shibasis.bifrost.Version
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun kotlinWrapper(
    target: String
): String =
    "org.jetbrains.kotlin-wrappers:kotlin-$target"


fun KotlinDependencyHandler.webBasic() {
    implementation(project.dependencies.enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:${Version.KotlinJSWrappers}"))
    implementation(kotlinWrapper("js"))
    implementation(kotlinWrapper("browser"))
    implementation(kotlinWrapper("history"))
    implementation(kotlinWrapper("typescript"))
}

fun KotlinDependencyHandler.webCamera() {
    implementation(kotlinWrapper("webrtc"))
}

fun KotlinDependencyHandler.react() {
    implementation(kotlinWrapper("emotion"))
    implementation(kotlinWrapper("react"))
    implementation(kotlinWrapper("react-dom"))
    implementation(kotlinWrapper("react-router-dom"))
}

fun KotlinDependencyHandler.webCoroutines(
    coroutines_version: String = Version.Coroutines
) {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${coroutines_version}")
}
