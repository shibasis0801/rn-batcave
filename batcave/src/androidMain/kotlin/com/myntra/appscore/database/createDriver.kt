package com.myntra.appscore.database

import android.app.Activity
import android.content.Context
import com.myntra.appscore.MainDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.android.AndroidSqliteDriver


actual class DriverProvider(context: Context) {
    private val driver = AndroidSqliteDriver(MainDatabase.Schema, context, "main.db")
    actual suspend fun get(): SqlDriver = driver
}
