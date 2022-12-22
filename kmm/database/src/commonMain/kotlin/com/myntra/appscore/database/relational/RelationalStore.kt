package com.myntra.appscore.database.relational
// Common for all
interface RelationalStore {
    object Capability {
        interface Secure {
            fun<T> getEncrypted(key: String): T
            fun<T> setEncrypted(key: String, value: T): Boolean
        }

        interface Listener {

        }

        interface SizeBound {

        }

        interface RawQuery {
            fun query(queryString: String): Cursor
        }
    }
}

class BrowserSQL: RelationalStore, RelationalStore.Capability.SizeBound {

}

class AndroidSQL: RelationalStore, RelationalStore.Capability.SizeBound, RelationalStore.Capability.RawQuery {
    override fun query(queryString: String): Cursor {
        return object: Cursor {
            override fun next(): Boolean {
                return true
            }

            override fun getString(index: Number): String {
                return ""
            }

            override fun getBytes(index: Number): ByteArray {
                return ByteArray(1)
            }

            override fun close() {

            }
        }
    }
}


interface SQL {
    fun query(queryString: String): Cursor
}

interface Cursor {
    fun next(): Boolean
    fun getString(index: Number): String
    fun getBytes(index: Number): ByteArray
    fun close(): Unit
}