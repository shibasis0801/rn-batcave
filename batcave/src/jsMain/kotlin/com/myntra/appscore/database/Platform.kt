package com.myntra.appscore.database

import com.myntra.appscore.MainDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.sqljs.initSqlDriver
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.koin.dsl.module

actual class Platform actual constructor() {
    actual val platform: String = window.navigator.userAgent
}



actual class DriverProvider {
    actual suspend fun get(): SqlDriver = initSqlDriver(MainDatabase.Schema).await()
}
