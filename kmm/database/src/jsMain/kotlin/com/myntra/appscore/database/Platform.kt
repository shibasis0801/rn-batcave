package com.myntra.appscore.database

import Dexie
import com.myntra.appscore.MainDatabase
import com.myntra.appscore.database.keyvalue.KeyValueStore
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.sqljs.initSqlDriver
import kotlinx.browser.window
import kotlinx.coroutines.await

actual class Platform actual constructor() {
    actual val platform: String = window.navigator.userAgent
}



actual class DriverProvider {
    actual suspend fun get(): SqlDriver = initSqlDriver(MainDatabase.Schema).await()
}

private fun createDexie(name: String): Dexie = js("new Dexie(name)").unsafeCast<Dexie>()

data class LEResponse(
    val id: Int,
    val content: String
)

class Dexie(override val name: String): KeyValueStore {
    private val dexie = createDexie(name)
    private val leResponse = dexie.table<LEResponse, Int>("leResponse")

    override fun <T> get(key: String): T {
        leResponse
            .toArray()
            .then({
                  it.forEach { println(it) }
            }, null)
        return 5 as T
    }

    override fun <T> set(key: String, value: T): Boolean {
        return true
    }
}