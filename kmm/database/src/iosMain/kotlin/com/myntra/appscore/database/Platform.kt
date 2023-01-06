package com.myntra.appscore.database

import com.myntra.appscore.MainDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import platform.Foundation.NSFileManager
import platform.Foundation.NSString
import platform.UIKit.UIDevice
import platform.darwin.NSObject
import platform.darwin.dispatch_queue_t
actual class Network {
    fun get() {
        return 2;
    }
}

class DarwinDatabaseConnector: PlatformDatabaseConnector {
    override fun getDriver() = NativeSqliteDriver(MainDatabase.Schema, "test.db")
    fun test() {
        val dispatchQueue: dispatch_queue_t
    }
}

















fun t() {
    val fileManager = NSFileManager.defaultManager
}


fun runBlockingQuery(sqlDatabase: SQLDatabase): Unit = runBlocking {
    println("PRINT SQL DATA")

    GlobalScope.launch {
        println("PRINT SQL DATA")
        sqlDatabase {
            println("PRINT SQL DATA")
//            helloQueries.selectAll { player_number, full_name ->
//                println("PRINT SQL DATA, $player_number, $full_name")
//            }.executeAsList()
        }
    }
}


