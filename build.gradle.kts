plugins {
    id("com.louiscad.complete-kotlin") version "1.1.0"
}

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
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.7.10")
        classpath("com.android.tools.build:gradle:7.2.0")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")
    }
}

group = "com.myntra.appscore"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "$rootDir/tester/node_modules/react-native/android")
        mavenCentral {
            // We don't want to fetch react-native from Maven Central as there are
            // older versions over there.
            content {
                excludeGroup("com.facebook.react")
            }
        }
    }
}
