plugins {
    id("java-gradle-plugin")
    `kotlin-dsl`
    kotlin("jvm") version "1.7.10"
}

repositories {
    google()
    mavenCentral()
    maven(url = "https://plugins.gradle.org/m2/")
}

dependencies {
    // Align Version of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.android.tools.build:gradle:7.2.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
}

gradlePlugin {
    // Define the plugin
    val plugin by plugins.creating {
        id = "dev.shibasis.bifrost.plugin"
        implementationClass = "dev.shibasis.bifrost.BifrostPlugin"
    }
}


val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.7"
}
