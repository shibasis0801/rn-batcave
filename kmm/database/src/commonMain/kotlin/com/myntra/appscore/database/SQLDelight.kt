package com.myntra.appscore.database

import com.myntra.appscore.MainDatabase
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.squareup.sqldelight.db.SqlCursor

interface PlatformDatabaseConnector {
    fun getDriver(): SqlDriver
}



class SQLDatabase(
    private val platformDatabaseConnector: PlatformDatabaseConnector
) {
    private val driver by lazy { platformDatabaseConnector.getDriver() }
    private val database by lazy { MainDatabase(driver) }

    operator fun <R> invoke(block: MainDatabase.() -> R): R {
        return database.block()
    }
}

interface ILayoutEngineQueries {
    fun getAllPages(): List<Page>
    fun getAllWidgets(): List<Widget>
    fun insertPage(page: Page)
    fun insertWidget(widget: Widget)
}


// If we don't use this object in web, then it will be dropped in DCE
// Alternate is to use another sourceSet -> mobileMain (preferred for removing accidental use)
class MobileLayoutEngineQueries(private val sql: SQLDatabase): ILayoutEngineQueries  {
    override fun getAllPages() = sql {
        pageQueries.getAllPages().executeAsList()
    }

    override fun getAllWidgets() = sql {
        widgetQueries.getAllWidgets().executeAsList()
    }

    override fun insertPage(page: Page) = sql {
        pageQueries.insert(page)
    }

    override fun insertWidget(widget: Widget) = sql {
        widgetQueries.insert(widget)
    }
}



// Blocking, use coroutines to schedule
fun test(sqlDatabase: SQLDatabase) = sqlDatabase {
    pageQueries.getAllPages()
        .executeAsList()
        .forEach { page ->

        }

}
