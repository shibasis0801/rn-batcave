package com.myntra.appscore.database

import android.content.Context
import com.myntra.appscore.MainDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver

class AndroidDatabaseConnector(context: Context): PlatformDatabaseConnector {
    // has context ref, make easy to remove
    private val driver = AndroidSqliteDriver(MainDatabase.Schema, context, "main.db")
    override fun getDriver() = driver
}