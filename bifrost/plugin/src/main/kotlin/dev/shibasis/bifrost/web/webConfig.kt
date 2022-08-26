package dev.shibasis.bifrost.web
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsTargetDsl

fun KotlinMultiplatformExtension.web(configure: KotlinJsTargetDsl.() -> Unit = {}) {
    js(IR) {
        compilations.all {
            kotlinOptions.freeCompilerArgs += listOf("-Xir-per-module")
        }
        browser {
            commonWebpackConfig {
                showProgress = true
                export = true
                progressReporter = true
                cssSupport.enabled = true
            }

            webpackTask {
                report = true
                sourceMaps = true //not supported in IR yet
            }
        }
        binaries.executable()

        configure()
    }
}
