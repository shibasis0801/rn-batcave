// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val ndkVersion by extra( "25.0.8775105")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral {
            content {
                excludeGroup("com.facebook.react")
            }
        }
        maven(url = "$rootDir/tester/node_modules/react-native/android")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.7.20")
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.4")
    }
}

allprojects {
    repositories {
        maven(url = "$rootDir/../node_modules/react-native/android")
        mavenCentral {
            content {
                excludeGroup("com.facebook.react")
            }
        }
        google()
        maven(url = "https://www.jitpack.io")
    }
    afterEvaluate {
        project.extensions.findByType<org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension>()?.let { ext ->
            ext.sourceSets.removeAll { sourceSet ->
                setOf(
                    "androidAndroidTestRelease",
                    "androidTestFixtures",
                    "androidTestFixturesDebug",
                    "androidTestFixturesRelease",
                ).contains(sourceSet.name)
            }
        }
    }
}
