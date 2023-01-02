package com.myntra.appscore.database

import com.myntra.appscore.MainDatabase
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.squareup.sqldelight.db.SqlCursor

expect class DriverProvider {
    suspend fun get(): SqlDriver
}

class SQLDatabase(private val driverProvider: DriverProvider) {
    private var mainDatabase: MainDatabase? = null

    suspend operator fun <R> invoke(block: suspend MainDatabase.() -> R): R {
        if (mainDatabase == null) {
            val driver = driverProvider.get()
            val cursor: SqlCursor
            mainDatabase = MainDatabase(driver)
        }
        return mainDatabase!!.block()
    }
}

suspend fun test(sqlDatabase: SQLDatabase) = sqlDatabase {
//    pageQueries.insert(Page(""))

}
