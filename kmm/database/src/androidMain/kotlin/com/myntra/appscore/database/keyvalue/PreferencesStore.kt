package com.myntra.appscore.database.keyvalue

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore



class PreferencesStore(
    context: Context,
    override val name: String
): KeyValueStore {
    val sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    override fun <T> get(key: String): T {
        TODO("Not yet implemented")
    }


    override fun <T> set(key: String, value: T): Boolean {
        TODO("Not yet implemented")
    }
}