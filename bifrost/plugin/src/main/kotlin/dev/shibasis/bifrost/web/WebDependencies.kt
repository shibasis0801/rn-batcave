package dev.shibasis.bifrost.web

import dev.shibasis.bifrost.Version
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun kotlinWrapper(
    target: String
): String =
    "org.jetbrains.kotlin-wrappers:kotlin-$target"


fun KotlinDependencyHandler.webBasic() {
    implementation(project.dependencies.enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:${Version.KotlinJSWrappers}"))
    implementation(kotlinWrapper("emotion"))
    implementation(kotlinWrapper("js"))
    implementation(kotlinWrapper("browser"))
    implementation(kotlinWrapper("history"))
}

fun KotlinDependencyHandler.camera() {
    implementation(kotlinWrapper("webrtc"))
}

fun KotlinDependencyHandler.react(
    kotlinWrappersVersion: String = Version.KotlinJSWrappers
) {
    implementation(kotlinWrapper("react"))
    implementation(kotlinWrapper("react-dom"))
}

fun KotlinDependencyHandler.router() {
    implementation(kotlinWrapper("react-router-dom"))
}

fun KotlinDependencyHandler.webCoroutines(
    coroutines_version: String = Version.Coroutines
) {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutines_version}")
}
