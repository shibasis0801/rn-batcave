@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package com.myntra.appscore.database.idb

import kotlin.js.*
import com.myntra.appscore.database.idb.IDBDatabase
import com.myntra.appscore.database.idb.IDBIndex
import com.myntra.appscore.database.idb.IDBObjectStore
import com.myntra.appscore.database.idb.IDBTransaction
import com.myntra.appscore.database.idb.IDBOpenDBRequest
import com.myntra.appscore.database.idb.IDBRequest
import com.myntra.appscore.database.idb.IDBCursorWithValue
import com.myntra.appscore.database.idb.IDBCursor

external fun wrap(value: IDBDatabase): IDBPDatabase__0

external fun wrap(value: IDBIndex): IDBPIndex__0

external fun wrap(value: IDBObjectStore): IDBPObjectStore__0

external fun wrap(value: IDBTransaction): IDBPTransaction__0

external fun wrap(value: IDBOpenDBRequest): Promise<IDBPDatabase__0?>

external fun <T> wrap(value: IDBRequest<T>): Promise<T>

external interface Unwrap {
    @nativeInvoke
    operator fun invoke(value: IDBPCursorWithValue<Any, ArrayLike<StoreNames<Any>>, Any, Any, String>): IDBCursorWithValue
    @nativeInvoke
    operator fun invoke(value: IDBPCursor<Any, ArrayLike<StoreNames<Any>>, Any, Any, String>): IDBCursor
    @nativeInvoke
    operator fun invoke(value: IDBPDatabase__0): IDBDatabase
    @nativeInvoke
    operator fun invoke(value: IDBPIndex<Any, ArrayLike<StoreNames<Any>>, Any, Any, String>): IDBIndex
    @nativeInvoke
    operator fun invoke(value: IDBPObjectStore<Any, ArrayLike<StoreNames<Any>>, Any, String>): IDBObjectStore
    @nativeInvoke
    operator fun invoke(value: IDBPTransaction<Any, ArrayLike<StoreNames<Any>>, String>): IDBTransaction
    @nativeInvoke
    operator fun <T : Any> invoke(value: Promise<IDBPDatabase<T>>): IDBOpenDBRequest
    @nativeInvoke
    operator fun invoke(value: Promise<IDBPDatabase__0>): IDBOpenDBRequest
    @nativeInvoke
    operator fun <T> invoke(value: Promise<T>): IDBRequest<T>
}