package com.myntra.appscore.database.keyvalue

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*
> Should allow implementations in DataStore, UserDefaults, IndexedDB
Explore
> Encryption through Tink
 */
interface KeyValueStore {
    val name: String
    fun<T> get(key: String): T
    fun<T> set(key: String, value: T): Boolean

}

object Capability {
    interface Secure {
        fun<T> getEncrypted(key: String): T
        fun<T> setEncrypted(key: String, value: T): Boolean
    }

    interface Listener {

    }
    interface SizeBound {
        fun setMaxSize(bytes: Int)
    }
}

object Encrypter: Capability.Secure {
    override fun <T> getEncrypted(key: String): T {
        TODO("Not yet implemented")
    }

    override fun <T> setEncrypted(key: String, value: T): Boolean {
        TODO("Not yet implemented")
    }
}

class PreferencesKV(): KeyValueStore, Capability.Secure by Encrypter {
    override val name: String
        get() = TODO("Not yet implemented")

    override fun <T> get(key: String): T {
        TODO("Not yet implemented")
    }

    override fun <T> set(key: String, value: T): Boolean {
        TODO("Not yet implemented")
    }
}

suspend fun test(kv: KeyValueStore) {
    withContext(Dispatchers.Main) {
        kv.set("3", "")
        kv.get<String>("name")

    }

    val pref = PreferencesKV()

    if (kv is Capability.Secure) {
        kv.getEncrypted<String>("key")
    }

    if (kv is Capability.SizeBound) {
        kv.setMaxSize(2);
    }
}
