package com.myntra.appscore.database

import com.juul.indexeddb.Database
import com.juul.indexeddb.openDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

abstract class WebLayoutEngineQueries(private val db: WebDatabase): ILayoutEngineQueries {}

@JsExport
class WebDatabase(val name: String) {
//    private val dexie = createDexie(name)
//
//    val pageTable = dexie.table<Page, Int>("Page")
//    val widgetTable = dexie.table<Widget, Int>("Widget")



    fun test(): Promise<String> {
        return GlobalScope.promise {
            val db = openDatabase(name, 1) { database, _, _ ->
                val pageTable = database.createObjectStore("Page")
//                val widgetTable = database.createObjectStore("Widget")
            }

            db.writeTransaction("Page") {
                val pageTable = objectStore("Page")
                pageTable.add("sanu")
            }

            db.transaction("Page") {
                val pageTable = objectStore("Page")
                pageTable.getAll()[0].toString()
            }
        }

    }
}