package dev.shibasis.bifrost.android

import org.gradle.api.Project
import org.gradle.kotlin.dsl.*
import org.gradle.kotlin.dsl.DependencyHandlerScope
import dev.shibasis.bifrost.utils.*
import dev.shibasis.bifrost.Version
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun androidBasic(
    activity_version: String = Version.Activity,
    fragment_version: String = Version.Fragment
) = listOf(
    module("org.jetbrains.kotlin:kotlin-stdlib:${Version.SDK.Kotlin}"),
    module("androidx.activity:activity:$activity_version"),
    module("androidx.activity:activity-ktx:$activity_version"),
    module("androidx.fragment:fragment:$fragment_version"),
    module("androidx.fragment:fragment-ktx:$fragment_version"),
    module("androidx.appcompat:appcompat:1.4.1"),
    module("androidx.constraintlayout:constraintlayout:2.0.4"),
    module("com.google.android.material:material:1.5.0"),
    module("com.benasher44:uuid:0.4.0"),
)


fun KotlinDependencyHandler.basic(
    activity_version: String = Version.Activity,
    fragment_version: String = Version.Fragment
) = installModules(androidBasic(activity_version, fragment_version))

fun DependencyHandlerScope.basic(
    activity_version: String = Version.Activity,
    fragment_version: String = Version.Fragment
) {
    installModules(androidBasic(activity_version, fragment_version))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")}


fun androidLifecycle(
    lifecycle_version: String = Version.Lifecycle
) = listOf(
    module("androidx.lifecycle:lifecycle-service:$lifecycle_version"),
    module("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"),
    module("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"),
    module("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"),
    module("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"),
    module("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"),
    module("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version"),
)

fun KotlinDependencyHandler.lifecycle(
    lifecycle_version: String = Version.Lifecycle
) = installModules(androidLifecycle(lifecycle_version))

fun DependencyHandlerScope.lifecycle(
    lifecycle_version: String = Version.Lifecycle
) = installModules(androidLifecycle(lifecycle_version))


fun composeList(
    compose_version: String = Version.Compose
) = listOf(
    module("androidx.compose.compiler:compiler:$compose_version"),
    module("androidx.compose.ui:ui:$compose_version"),
    module("androidx.compose.ui:ui-tooling:$compose_version"),
    module("androidx.compose.ui:ui-tooling-preview:$compose_version"),
    module("androidx.compose.foundation:foundation:$compose_version"),
    module("androidx.navigation:navigation-compose:2.4.1"),
    module("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"),
    module("androidx.compose.material3:material3:1.0.0-alpha05"),
    module("androidx.compose.material:material:$compose_version"),
    module("androidx.compose.material:material-icons-core:$compose_version"),
    module("androidx.compose.material:material-icons-extended:$compose_version"),
    module("androidx.compose.runtime:runtime-livedata:$compose_version"),
    module("androidx.activity:activity-compose:1.4.0"),
//    module("com.google.accompanist:accompanist-webview:0.23.1"),
)

fun KotlinDependencyHandler.androidCompose(
    compose_version: String = Version.Compose
) = installModules(composeList(compose_version))

fun DependencyHandlerScope.androidCompose(
    compose_version: String = Version.Compose
) = installModules(composeList(compose_version))


fun javascript() = listOf(
    "androidx.browser:browser:1.3.0" // For PWA, Also use QuickJS
)

fun networkingList(
    okhttp_version: String = Version.OkHttp,
    klaxon_version: String = Version.Klaxon
) = listOf(
        module("com.squareup.okhttp3:okhttp:$okhttp_version"),
        module("com.beust:klaxon:$klaxon_version"),
        module("net.javacrumbs.future-converter:future-converter-java8-guava:1.2.0"),
    )

fun KotlinDependencyHandler.networking(
    okhttp_version: String = Version.OkHttp,
    klaxon_version: String = Version.Klaxon
) = installModules(networkingList(okhttp_version, klaxon_version))
fun DependencyHandlerScope.networking(
    okhttp_version: String = Version.OkHttp,
    klaxon_version: String = Version.Klaxon
) = installModules(networkingList(okhttp_version, klaxon_version))


fun workManagerList(work_version: String = Version.WorkManager) =
    listOf(module("androidx.work:work-runtime-ktx:$work_version"))

fun DependencyHandlerScope.workManager(
    work_version: String = Version.WorkManager
) = installModules(workManagerList(work_version))

fun KotlinDependencyHandler.workManager(
    work_version: String = Version.WorkManager
) = installModules(workManagerList(work_version))



fun extensionsList() = listOf(
    module("androidx.core:core-ktx:1.7.0"),
    module("androidx.collection:collection-ktx:1.2.0")
)

fun DependencyHandlerScope.extensions() = installModules(extensionsList())
fun KotlinDependencyHandler.extensions() = installModules(extensionsList())

fun databaseList(
    room_version: String = Version.Room
) = listOf(
    module("androidx.datastore:datastore-preferences:1.0.0"),
    module("androidx.room:room-runtime:$room_version"),
    module("androidx.room:room-ktx:$room_version"),
)

fun DependencyHandlerScope.database(
    room_version: String = Version.Room
) {
    installModules(databaseList(room_version))
}
fun KotlinDependencyHandler.database(
    room_version: String = Version.Room
)  = installModules(databaseList(room_version))


fun cameraList(
    camerax_version: String = Version.CameraX,
    cameraview_version: String = Version.CameraView
) = listOf(
    module("androidx.camera:camera-camera2:$camerax_version"),
    module("androidx.camera:camera-lifecycle:$camerax_version"),
    module("androidx.camera:camera-view:$cameraview_version"),
    module("androidx.camera:camera-extensions:$cameraview_version"),
)

fun KotlinDependencyHandler.camera(
    camerax_version: String = Version.CameraX,
    cameraview_version: String = Version.CameraView
) = installModules(cameraList(camerax_version, cameraview_version))
fun DependencyHandlerScope.camera(
    camerax_version: String = Version.CameraX,
    cameraview_version: String = Version.CameraView
) = installModules(cameraList(camerax_version, cameraview_version))

fun navigationList(
    nav_version: String = Version.Navigation
) = listOf(
    module("androidx.navigation:navigation-fragment:$nav_version"),
    module("androidx.navigation:navigation-ui:$nav_version"),
    module("androidx.navigation:navigation-fragment-ktx:$nav_version"),
    module("androidx.navigation:navigation-ui-ktx:$nav_version"),
    module("androidx.navigation:navigation-dynamic-features-fragment:$nav_version"),
)

fun KotlinDependencyHandler.navigation(
    nav_version: String = Version.Navigation
) = installModules(navigationList(nav_version))
fun DependencyHandlerScope.navigation(
    nav_version: String = Version.Navigation
) = installModules(navigationList(nav_version))


fun firebaseList() = listOf(
    module("com.google.firebase:firebase-firestore-ktx"),
    module("com.google.firebase:firebase-storage-ktx"),
    module("com.google.firebase:firebase-database-ktx"),
    module("com.google.firebase:firebase-auth-ktx"),
    module("com.google.firebase:firebase-config-ktx"),
    module("com.google.firebase:firebase-analytics-ktx"),
    module("com.google.firebase:firebase-crashlytics-ktx"),
    module("com.google.firebase:firebase-messaging-ktx"),
    module("com.google.android.gms:play-services-auth:20.1.0"),
)

fun DependencyHandlerScope.firebase(
    firebaseVersion: String = Version.Firebase
) {
    val firebaseBOM = "com.google.firebase:firebase-bom:$firebaseVersion"
    implementation(firebaseBOM)
    installModules(firebaseList())
}

fun KotlinDependencyHandler.firebase(
    project: Project,
    firebaseVersion: String = Version.Firebase
) {
    val firebaseBOM = "com.google.firebase:firebase-bom:$firebaseVersion"
    implementation(project.dependencies.enforcedPlatform(firebaseBOM))
    installModules(firebaseList())
}

fun external() = listOf<String>(
//    "com.github.GrenderG:Toasty:1.4.2"
//                "com.anggrayudi:storage:0.8.1" //Use if StorageComponent does not pan out.
)

fun machineLearningList() = listOf(
    module("com.google.mlkit:image-labeling:17.0.0"),
    module("com.google.mlkit:text-recognition:16.0.0-beta1"),
    module("com.google.mlkit:text-recognition-devanagari:16.0.0-beta1"),
)

fun DependencyHandlerScope.machineLearning() = installModules(machineLearningList())
fun KotlinDependencyHandler.machineLearning() = installModules(machineLearningList())


fun coroutinesCore(
    coroutines_version: String = Version.Coroutines
) = listOf(module("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"))

fun KotlinDependencyHandler.jvmCoroutines(
    coroutines_version: String = Version.Coroutines
) = installModules(coroutinesCore(coroutines_version))

fun coroutinesList(
    coroutines_version: String = Version.Coroutines
) = coroutinesCore(coroutines_version) + listOf(
    module("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"),
    module("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutines_version"),
)

fun KotlinDependencyHandler.androidCoroutines(
    coroutines_version: String = Version.Coroutines
) = installModules(coroutinesList(coroutines_version))
fun DependencyHandlerScope.androidCoroutines(
    coroutines_version: String = Version.Coroutines
) = installModules(coroutinesList(coroutines_version))




fun DependencyHandlerScope.flipper(
    flipper_version: String = Version.Flipper,
    leakcanary_version: String = Version.LeakCanary,
    soloader_version: String = Version.SoLoader
) {
    debugImplementation("com.facebook.flipper:flipper:$flipper_version")
    debugImplementation("com.facebook.flipper:flipper-leakcanary2-plugin:$flipper_version")
    debugImplementation("com.squareup.leakcanary:leakcanary-android:$leakcanary_version")
    debugImplementation("com.facebook.flipper:flipper-network-plugin:$flipper_version")

    debugImplementation("com.facebook.soloader:soloader:$soloader_version")
    releaseImplementation("com.facebook.flipper:flipper-noop:$flipper_version")
}

val driveItems = listOf(
    module("com.google.api-client:google-api-client-android:1.33.0", listOf(
        exclude(group = "org.apache.httpcomponents"),
        exclude(module = "guava-jdk5")
    )),
    module("com.google.apis:google-api-services-drive:v3-rev20211107-1.32.1", listOf(
        exclude(group = "org.apache.httpcomponents"),
        exclude(module = "guava-jdk5")
    )),
    module("com.google.http-client:google-http-client:1.41.4", listOf(
        exclude(group = "org.apache.httpcomponents")
    ))
)



fun DependencyHandlerScope.drive() = installModules(driveItems)
fun KotlinDependencyHandler.drive() = installModules(driveItems)


fun coilItems(coil_version: String = Version.Coil) = listOf(
    module("io.coil-kt:coil:$coil_version"),
    module("io.coil-kt:coil-compose:$coil_version")
)

fun DependencyHandlerScope.coil() = installModules(coilItems())
fun KotlinDependencyHandler.coil() = installModules(coilItems())
// See if generics can help this (no duck typing as of now)




//pg 41 real world compose
