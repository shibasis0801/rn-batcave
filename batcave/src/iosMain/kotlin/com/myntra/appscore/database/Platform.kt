package com.myntra.appscore.database


import com.myntra.appscore.MainDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import platform.Foundation.NSString

import platform.UIKit.UIDevice
import platform.darwin.NSObject

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual class DriverProvider {
    actual suspend fun get(): SqlDriver = NativeSqliteDriver(MainDatabase.Schema, "test.db")
}


fun runBlockingQuery(sqlDatabase: SQLDatabase): Unit = runBlocking {
    println("PRINT SQL DATA")
    GlobalScope.launch {
        println("PRINT SQL DATA")
        sqlDatabase {
            println("PRINT SQL DATA")
            helloQueries.selectAll { player_number, full_name ->
                println("PRINT SQL DATA, $player_number, $full_name")
            }.executeAsList()
        }
    }
}


class Cursor {
    fun getNext(): NSString {
        return "Shibasis" as NSString
    }
}

