package dev.shibasis.bifrost.utils

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.add

fun DependencyHandlerScope.wrap(
    term: String,
    dependencyNotation: String,
    dependencyConfiguration: (ExternalModuleDependency.() -> Unit)
) = add(term, dependencyNotation, dependencyConfiguration)


typealias Implementation = (
    dependencyNotation: String,
    dependencyConfiguration: (ExternalModuleDependency.() -> Unit)
) -> Dependency

fun DependencyHandlerScope.implementation(
    dependencyNotation: String,
    dependencyConfiguration: (ExternalModuleDependency.() -> Unit) = {}
) = wrap("implementation", dependencyNotation, dependencyConfiguration)



fun DependencyHandlerScope.debugImplementation(
    dependencyNotation: String,
    dependencyConfiguration: (ExternalModuleDependency.() -> Unit) = {}
) = wrap("debugImplementation", dependencyNotation, dependencyConfiguration)

fun DependencyHandlerScope.releaseImplementation(
    dependencyNotation: String,
    dependencyConfiguration: (ExternalModuleDependency.() -> Unit) = {}
) = wrap("releaseImplementation", dependencyNotation, dependencyConfiguration)


fun DependencyHandlerScope.api(
    dependencyNotation: String,
    dependencyConfiguration: (ExternalModuleDependency.() -> Unit) = {}
) = wrap("api", dependencyNotation, dependencyConfiguration)



fun DependencyHandlerScope.testImplementation(
    dependencyNotation: String,
    dependencyConfiguration: (ExternalModuleDependency.() -> Unit) = {}
) = wrap("testImplementation", dependencyNotation, dependencyConfiguration)



fun DependencyHandlerScope.androidTestImplementation(
    dependencyNotation: String,
    dependencyConfiguration: (ExternalModuleDependency.() -> Unit) = {}
) = wrap("androidTestImplementation", dependencyNotation, dependencyConfiguration)


fun DependencyHandlerScope.kapt(
    dependencyNotation: String,
    dependencyConfiguration: (ExternalModuleDependency.() -> Unit) = {}
) = wrap("kapt", dependencyNotation, dependencyConfiguration)


