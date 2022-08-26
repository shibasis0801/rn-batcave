package com.myntra.appscore.database.keyvalue

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*
> Should allow implementations in DataStore, UserDefaults, IndexedDB
Explore
> Typed Objects with Protobuf
> Encryption through Tink
 */
interface KeyValueInterface {
    fun<T> get(key: String): T
    fun<T> set(key: String, value: T): Boolean
}

suspend fun test(kv: KeyValueInterface) {
    withContext(Dispatchers.Main) {
        kv.set("3", "")
        kv.get<String>("name")

    }
}