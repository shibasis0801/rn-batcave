package dev.shibasis.bifrost.common

import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import dev.shibasis.bifrost.Version

fun KotlinDependencyHandler.serialization(serializationVersion: String = Version.Serialization, protobuf: Boolean = false) {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
    if (protobuf)
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:$serializationVersion")
}


fun KotlinDependencyHandler.coroutines(coroutinesVersion: String = Version.Coroutines) {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
}
