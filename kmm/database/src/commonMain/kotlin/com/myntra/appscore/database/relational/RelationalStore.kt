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

        }
    }
}
