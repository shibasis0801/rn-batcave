package dev.shibasis.bifrost.utils

import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.exclude
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

data class exclude(val group: String? = null, val module: String? = null)
data class module(val dependency: String, val excludes: List<exclude> = listOf())

fun installModules(modules: List<module>, implementation: Implementation) {
    modules.forEach {
        implementation(it.dependency) {
            it.excludes.forEach {
                exclude(it.group, it.module)
            }
        }
    }
}

fun KotlinDependencyHandler.installModules(modules: List<module>) = installModules(modules, ::implementation)
fun DependencyHandlerScope.installModules(modules: List<module>) = installModules(modules, ::implementation)
