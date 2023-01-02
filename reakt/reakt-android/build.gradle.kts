import dev.shibasis.bifrost.android.*
import dev.shibasis.bifrost.*
//import org.bytedeco.gradle.javacpp.BuildTask
import kotlin.collections.listOf
import kotlin.arrayOf

plugins {
    id("dev.shibasis.bifrost.plugin")
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
//    id("org.bytedeco.gradle-javacpp-build") version "1.5.8"
}

android {
    namespace = "com.myntra.appscore.reakt"
    libraryDefaults(file("./CMakeLists.txt"))
    kotlinOptions {
        jvmTarget = Version.SDK.Java.asString
    }
}

dependencies {
    basic()
//    api("org.bytedeco:javacpp:1.5.8")
    api("com.facebook.react:react-native:+")
    api("com.facebook.fbjni:fbjni:0.2.2")
}


val DirectoryProperty.path: String
    get() = get().asFile.path

//android.libraryVariants.all {
//    val variant = name.capitalize()
//    val root = "com/myntra/appscore/reakt"
//    val javaCompile = project.tasks.getByName<JavaCompile>("compile${variant}JavaWithJavac")
//
//    val Tasks = object {
//        val Compile = "javacppCompileJava$variant"
//        val Build = "javacppBuildParser$variant"
//        val Generate = "javacppBuildCompiler$variant"
//    }
//
//
//    tasks.register<JavaCompile>(Tasks.Compile) {
//        include("com/myntra/appscore/reakt/NativeLibraryConfig.java")
//        source = javaCompile.source
//        classpath = javaCompile.classpath
//        destinationDirectory.set(javaCompile.destinationDirectory)
//    }
//
//    tasks.register<BuildTask>(Tasks.Build) {
//        dependsOn(Tasks.Compile)
//        classPath = arrayOf(javaCompile.destinationDirectory.path)
//        includePath = arrayOf("$projectDir/src/main/cpp/")
//        classOrPackageNames = arrayOf("com.myntra.appscore.reakt.NativeLibraryConfig")
//        outputDirectory = file("$projectDir/src/main/java/")
//    }
//
//    javaCompile.dependsOn(Tasks.Build)
//
//    tasks.register<BuildTask>(Tasks.Generate) {
//        dependsOn(javaCompile)
//        classPath = arrayOf(javaCompile.destinationDirectory.path)
//        classOrPackageNames = arrayOf("com.myntra.appscore.reakt.generated.NativeLibrary")
//        compile = false
//        deleteJniFiles = false
//        outputDirectory = file("$projectDir/src/main/cpp")
//    }
//
//    project.tasks
//        .filter { it.name.startsWith("configureCMake$variant") }
//        .forEach { it.dependsOn(Tasks.Generate) }
//}

