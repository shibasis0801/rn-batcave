@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package com.myntra.appscore.database.idb

import kotlin.js.*
import org.khronos.webgl.*
import kotlinx.js.AsyncIterableIterator


external interface OpenDBCallbacks<DBTypes> {
    val upgrade: ((database: IDBPDatabase<DBTypes>, oldVersion: Number, newVersion: Number?, transaction: IDBPTransaction<DBTypes, ArrayLike<StoreNames<DBTypes>>, String /* "versionchange" */>, event: IDBVersionChangeEvent) -> Unit)?
    val blocked: ((currentVersion: Number, blockedVersion: Number?, event: IDBVersionChangeEvent) -> Unit)?
    val blocking: ((currentVersion: Number, blockedVersion: Number?, event: IDBVersionChangeEvent) -> Unit)?
    val terminated: (() -> Unit)?
}

external fun <DBTypes> openDB(name: String, version: Number = definedExternally, callback: OpenDBCallbacks<DBTypes> = definedExternally): Promise<IDBPDatabase<DBTypes>>

external interface DeleteDBCallbacks {
    val blocked: ((currentVersion: Number, event: IDBVersionChangeEvent) -> Unit)?
}

external fun deleteDB(name: String, __1: DeleteDBCallbacks = definedExternally): Promise<Unit>

typealias KeyToKeyNoIndex<T> = Any

typealias ValuesOf<T> = Any

typealias KnownKeys<T> = ValuesOf<KeyToKeyNoIndex<T>>

typealias Omit<T, K> = Any

external interface DBSchema {
    @nativeGetter
    operator fun get(s: String): DBSchemaValue?
    @nativeSetter
    operator fun set(s: String, value: DBSchemaValue)
}

external interface IndexKeys {
    @nativeGetter
    operator fun get(s: String): dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */
    @nativeSetter
    operator fun set(s: String, value: Number)
    @nativeSetter
    operator fun set(s: String, value: String)
    @nativeSetter
    operator fun set(s: String, value: Date)
    @nativeSetter
    operator fun set(s: String, value: ArrayBufferView)
    @nativeSetter
    operator fun set(s: String, value: ArrayBuffer)
    @nativeSetter
    operator fun set(s: String, value: IDBArrayKey)
}

external interface DBSchemaValue {
    var key: dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */
        get() = definedExternally
        set(value) = definedExternally
    var value: Any
    var indexes: IndexKeys?
        get() = definedExternally
        set(value) = definedExternally
}

typealias StoreNames<DBTypes> = Any

typealias StoreValue<DBTypes, StoreName> = Any

typealias StoreKey<DBTypes, StoreName> = Any

typealias IndexNames<DBTypes, StoreName> = Any

typealias IndexKey<DBTypes, StoreName, IndexName> = Any

typealias CursorSource<DBTypes, TxStores, StoreName, IndexName, Mode> = Any

typealias CursorKey<DBTypes, StoreName, IndexName> = Any

typealias IDBPDatabaseExtends = Omit<IDBDatabase, String /* "createObjectStore" | "deleteObjectStore" | "transaction" | "objectStoreNames" */>

external interface TypedDOMStringList<T : String> : DOMStringList {
    fun contains(string: T): Boolean
    override fun item(index: Number): T?
    @nativeGetter
    override operator fun get(index: Number): T?
    @nativeSetter
    operator fun set(index: Number, value: T)
}

external interface IDBTransactionOptions {
    var durability: String? /* "default" | "strict" | "relaxed" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface IDBPDatabase<DBTypes> : IDBPDatabaseExtends {
    var objectStoreNames: TypedDOMStringList<String>
    fun <Name : StoreNames<DBTypes>> createObjectStore(name: Name, optionalParameters: IDBObjectStoreParameters = definedExternally): IDBPObjectStore<DBTypes, ArrayLike<StoreNames<DBTypes>>, Name, String /* "versionchange" */>
    fun deleteObjectStore(name: StoreNames<DBTypes>)
    fun <Name : StoreNames<DBTypes>, Mode : String> transaction(storeNames: Name, mode: Mode = definedExternally, options: IDBTransactionOptions = definedExternally): IDBPTransaction<DBTypes, dynamic /* JsTuple<Name> */, Mode>
    fun <Name : StoreNames<DBTypes>, Mode : String> transaction(storeNames: Name): IDBPTransaction<DBTypes, dynamic /* JsTuple<Name> */, Mode>
    fun <Name : StoreNames<DBTypes>, Mode : String> transaction(storeNames: Name, mode: Mode = definedExternally): IDBPTransaction<DBTypes, dynamic /* JsTuple<Name> */, Mode>
    fun <Names : ArrayLike<StoreNames<DBTypes>>, Mode : String> transaction(storeNames: Names, mode: Mode = definedExternally, options: IDBTransactionOptions = definedExternally): IDBPTransaction<DBTypes, Names, Mode>
    fun <Names : ArrayLike<StoreNames<DBTypes>>, Mode : String> transaction(storeNames: Names): IDBPTransaction<DBTypes, Names, Mode>
    fun <Names : ArrayLike<StoreNames<DBTypes>>, Mode : String> transaction(storeNames: Names, mode: Mode = definedExternally): IDBPTransaction<DBTypes, Names, Mode>
    fun <Name : StoreNames<DBTypes>> add(storeName: Name, value: StoreValue<DBTypes, Name>, key: StoreKey<DBTypes, Name> = definedExternally): Promise<StoreKey<DBTypes, Name>>
    fun <Name : StoreNames<DBTypes>> add(storeName: Name, value: StoreValue<DBTypes, Name>): Promise<StoreKey<DBTypes, Name>>
    fun <Name : StoreNames<DBTypes>> add(storeName: Name, value: StoreValue<DBTypes, Name>, key: IDBKeyRange = definedExternally): Promise<StoreKey<DBTypes, Name>>
    fun clear(name: StoreNames<DBTypes>): Promise<Unit>
    fun <Name : StoreNames<DBTypes>> count(storeName: Name, key: StoreKey<DBTypes, Name>? = definedExternally): Promise<Number>
    fun <Name : StoreNames<DBTypes>> count(storeName: Name): Promise<Number>
    fun <Name : StoreNames<DBTypes>> count(storeName: Name, key: IDBKeyRange? = definedExternally): Promise<Number>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> countFromIndex(storeName: Name, indexName: IndexName, key: IndexKey<DBTypes, Name, IndexName>? = definedExternally): Promise<Number>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> countFromIndex(storeName: Name, indexName: IndexName): Promise<Number>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> countFromIndex(storeName: Name, indexName: IndexName, key: IDBKeyRange? = definedExternally): Promise<Number>
    fun <Name : StoreNames<DBTypes>> delete(storeName: Name, key: StoreKey<DBTypes, Name>): Promise<Unit>
    fun <Name : StoreNames<DBTypes>> delete(storeName: Name, key: IDBKeyRange): Promise<Unit>
    fun <Name : StoreNames<DBTypes>> get(storeName: Name, query: StoreKey<DBTypes, Name>): Promise<StoreValue<DBTypes, Name>?>
    fun <Name : StoreNames<DBTypes>> get(storeName: Name, query: IDBKeyRange): Promise<StoreValue<DBTypes, Name>?>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getFromIndex(storeName: Name, indexName: IndexName, query: IndexKey<DBTypes, Name, IndexName>): Promise<StoreValue<DBTypes, Name>?>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getFromIndex(storeName: Name, indexName: IndexName, query: IDBKeyRange): Promise<StoreValue<DBTypes, Name>?>
    fun <Name : StoreNames<DBTypes>> getAll(storeName: Name, query: StoreKey<DBTypes, Name>? = definedExternally, count: Number = definedExternally): Promise<Array<StoreValue<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>> getAll(storeName: Name): Promise<Array<StoreValue<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>> getAll(storeName: Name, query: StoreKey<DBTypes, Name>? = definedExternally): Promise<Array<StoreValue<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>> getAll(storeName: Name, query: IDBKeyRange? = definedExternally, count: Number = definedExternally): Promise<Array<StoreValue<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>> getAll(storeName: Name, query: IDBKeyRange? = definedExternally): Promise<Array<StoreValue<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getAllFromIndex(storeName: Name, indexName: IndexName, query: IndexKey<DBTypes, Name, IndexName>? = definedExternally, count: Number = definedExternally): Promise<Array<StoreValue<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getAllFromIndex(storeName: Name, indexName: IndexName): Promise<Array<StoreValue<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getAllFromIndex(storeName: Name, indexName: IndexName, query: IndexKey<DBTypes, Name, IndexName>? = definedExternally): Promise<Array<StoreValue<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getAllFromIndex(storeName: Name, indexName: IndexName, query: IDBKeyRange? = definedExternally, count: Number = definedExternally): Promise<Array<StoreValue<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getAllFromIndex(storeName: Name, indexName: IndexName, query: IDBKeyRange? = definedExternally): Promise<Array<StoreValue<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>> getAllKeys(storeName: Name, query: StoreKey<DBTypes, Name>? = definedExternally, count: Number = definedExternally): Promise<Array<StoreKey<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>> getAllKeys(storeName: Name): Promise<Array<StoreKey<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>> getAllKeys(storeName: Name, query: StoreKey<DBTypes, Name>? = definedExternally): Promise<Array<StoreKey<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>> getAllKeys(storeName: Name, query: IDBKeyRange? = definedExternally, count: Number = definedExternally): Promise<Array<StoreKey<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>> getAllKeys(storeName: Name, query: IDBKeyRange? = definedExternally): Promise<Array<StoreKey<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getAllKeysFromIndex(storeName: Name, indexName: IndexName, query: IndexKey<DBTypes, Name, IndexName>? = definedExternally, count: Number = definedExternally): Promise<Array<StoreKey<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getAllKeysFromIndex(storeName: Name, indexName: IndexName): Promise<Array<StoreKey<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getAllKeysFromIndex(storeName: Name, indexName: IndexName, query: IndexKey<DBTypes, Name, IndexName>? = definedExternally): Promise<Array<StoreKey<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getAllKeysFromIndex(storeName: Name, indexName: IndexName, query: IDBKeyRange? = definedExternally, count: Number = definedExternally): Promise<Array<StoreKey<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getAllKeysFromIndex(storeName: Name, indexName: IndexName, query: IDBKeyRange? = definedExternally): Promise<Array<StoreKey<DBTypes, Name>>>
    fun <Name : StoreNames<DBTypes>> getKey(storeName: Name, query: StoreKey<DBTypes, Name>): Promise<StoreKey<DBTypes, Name>?>
    fun <Name : StoreNames<DBTypes>> getKey(storeName: Name, query: IDBKeyRange): Promise<StoreKey<DBTypes, Name>?>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getKeyFromIndex(storeName: Name, indexName: IndexName, query: IndexKey<DBTypes, Name, IndexName>): Promise<StoreKey<DBTypes, Name>?>
    fun <Name : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, Name>> getKeyFromIndex(storeName: Name, indexName: IndexName, query: IDBKeyRange): Promise<StoreKey<DBTypes, Name>?>
    fun <Name : StoreNames<DBTypes>> put(storeName: Name, value: StoreValue<DBTypes, Name>, key: StoreKey<DBTypes, Name> = definedExternally): Promise<StoreKey<DBTypes, Name>>
    fun <Name : StoreNames<DBTypes>> put(storeName: Name, value: StoreValue<DBTypes, Name>): Promise<StoreKey<DBTypes, Name>>
    fun <Name : StoreNames<DBTypes>> put(storeName: Name, value: StoreValue<DBTypes, Name>, key: IDBKeyRange = definedExternally): Promise<StoreKey<DBTypes, Name>>
}

external interface IDBPDatabase__0 : IDBPDatabase<Any>

typealias IDBPTransactionExtends = Omit<IDBTransaction, String /* "db" | "objectStore" | "objectStoreNames" */>

external interface IDBPTransaction<DBTypes, TxStores : ArrayLike<StoreNames<DBTypes>>, Mode : String> : IDBPTransactionExtends {
    var mode: Mode
    var objectStoreNames: TypedDOMStringList<String>
    var db: IDBPDatabase<DBTypes>
    var done: Promise<Unit>
    var store: Any
    fun <StoreName : Any> objectStore(name: StoreName): IDBPObjectStore<DBTypes, TxStores, StoreName, Mode>
}

external interface IDBPTransaction__0 : IDBPTransaction<Any, ArrayLike<StoreNames<Any>>, String /* "readonly" */>

typealias IDBPObjectStoreExtends = Omit<IDBObjectStore, String /* "transaction" | "add" | "clear" | "count" | "createIndex" | "delete" | "get" | "getAll" | "getAllKeys" | "getKey" | "index" | "openCursor" | "openKeyCursor" | "put" | "indexNames" */>

external interface IDBPObjectStore<DBTypes, TxStores : ArrayLike<StoreNames<DBTypes>>, StoreName : StoreNames<DBTypes>, Mode : String> : IDBPObjectStoreExtends {
    var indexNames: TypedDOMStringList<String>
    var transaction: IDBPTransaction<DBTypes, TxStores, Mode>
    var add: Any
    var clear: Any
    fun count(key: StoreKey<DBTypes, StoreName>? = definedExternally): Promise<Number>
    fun count(): Promise<Number>
    fun count(key: IDBKeyRange? = definedExternally): Promise<Number>
    var createIndex: Any
    var delete: Any
    fun get(query: StoreKey<DBTypes, StoreName>): Promise<StoreValue<DBTypes, StoreName>?>
    fun get(query: IDBKeyRange): Promise<StoreValue<DBTypes, StoreName>?>
    fun getAll(query: StoreKey<DBTypes, StoreName>? = definedExternally, count: Number = definedExternally): Promise<Array<StoreValue<DBTypes, StoreName>>>
    fun getAll(): Promise<Array<StoreValue<DBTypes, StoreName>>>
    fun getAll(query: StoreKey<DBTypes, StoreName>? = definedExternally): Promise<Array<StoreValue<DBTypes, StoreName>>>
    fun getAll(query: IDBKeyRange? = definedExternally, count: Number = definedExternally): Promise<Array<StoreValue<DBTypes, StoreName>>>
    fun getAll(query: IDBKeyRange? = definedExternally): Promise<Array<StoreValue<DBTypes, StoreName>>>
    fun getAllKeys(query: StoreKey<DBTypes, StoreName>? = definedExternally, count: Number = definedExternally): Promise<Array<StoreKey<DBTypes, StoreName>>>
    fun getAllKeys(): Promise<Array<StoreKey<DBTypes, StoreName>>>
    fun getAllKeys(query: StoreKey<DBTypes, StoreName>? = definedExternally): Promise<Array<StoreKey<DBTypes, StoreName>>>
    fun getAllKeys(query: IDBKeyRange? = definedExternally, count: Number = definedExternally): Promise<Array<StoreKey<DBTypes, StoreName>>>
    fun getAllKeys(query: IDBKeyRange? = definedExternally): Promise<Array<StoreKey<DBTypes, StoreName>>>
    fun getKey(query: StoreKey<DBTypes, StoreName>): Promise<StoreKey<DBTypes, StoreName>?>
    fun getKey(query: IDBKeyRange): Promise<StoreKey<DBTypes, StoreName>?>
    fun <IndexName : IndexNames<DBTypes, StoreName>> index(name: IndexName): IDBPIndex<DBTypes, TxStores, StoreName, IndexName, Mode>
    fun openCursor(query: StoreKey<DBTypes, StoreName>? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): Promise<IDBPCursorWithValue<DBTypes, TxStores, StoreName, Any, Mode>?>
    fun openCursor(): Promise<IDBPCursorWithValue<DBTypes, TxStores, StoreName, Any, Mode>?>
    fun openCursor(query: StoreKey<DBTypes, StoreName>? = definedExternally): Promise<IDBPCursorWithValue<DBTypes, TxStores, StoreName, Any, Mode>?>
    fun openCursor(query: IDBKeyRange? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): Promise<IDBPCursorWithValue<DBTypes, TxStores, StoreName, Any, Mode>?>
    fun openCursor(query: IDBKeyRange? = definedExternally): Promise<IDBPCursorWithValue<DBTypes, TxStores, StoreName, Any, Mode>?>
    fun openKeyCursor(query: StoreKey<DBTypes, StoreName>? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): Promise<IDBPCursor<DBTypes, TxStores, StoreName, Any, Mode>?>
    fun openKeyCursor(): Promise<IDBPCursor<DBTypes, TxStores, StoreName, Any, Mode>?>
    fun openKeyCursor(query: StoreKey<DBTypes, StoreName>? = definedExternally): Promise<IDBPCursor<DBTypes, TxStores, StoreName, Any, Mode>?>
    fun openKeyCursor(query: IDBKeyRange? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): Promise<IDBPCursor<DBTypes, TxStores, StoreName, Any, Mode>?>
    fun openKeyCursor(query: IDBKeyRange? = definedExternally): Promise<IDBPCursor<DBTypes, TxStores, StoreName, Any, Mode>?>
    var put: Any
    fun iterate(query: StoreKey<DBTypes, StoreName>? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): AsyncIterableIterator<IDBPCursorWithValueIteratorValue<DBTypes, TxStores, StoreName, Any, Mode>>
    fun iterate(): AsyncIterableIterator<IDBPCursorWithValueIteratorValue<DBTypes, TxStores, StoreName, Any, Mode>>
    fun iterate(query: StoreKey<DBTypes, StoreName>? = definedExternally): AsyncIterableIterator<IDBPCursorWithValueIteratorValue<DBTypes, TxStores, StoreName, Any, Mode>>
    fun iterate(query: IDBKeyRange? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): AsyncIterableIterator<IDBPCursorWithValueIteratorValue<DBTypes, TxStores, StoreName, Any, Mode>>
    fun iterate(query: IDBKeyRange? = definedExternally): AsyncIterableIterator<IDBPCursorWithValueIteratorValue<DBTypes, TxStores, StoreName, Any, Mode>>
}

external interface IDBPObjectStore__0 : IDBPObjectStore<Any, ArrayLike<StoreNames<Any>>, StoreNames<Any>, String /* "readonly" */>

typealias IDBPIndexExtends = Omit<IDBIndex, String /* "objectStore" | "count" | "get" | "getAll" | "getAllKeys" | "getKey" | "openCursor" | "openKeyCursor" */>

external interface IDBPIndex<DBTypes, TxStores : ArrayLike<StoreNames<DBTypes>>, StoreName : StoreNames<DBTypes>, IndexName : IndexNames<DBTypes, StoreName>, Mode : String> : IDBPIndexExtends {
    var objectStore: IDBPObjectStore<DBTypes, TxStores, StoreName, Mode>
    fun count(key: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally): Promise<Number>
    fun count(): Promise<Number>
    fun count(key: IDBKeyRange? = definedExternally): Promise<Number>
    fun get(query: IndexKey<DBTypes, StoreName, IndexName>): Promise<StoreValue<DBTypes, StoreName>?>
    fun get(query: IDBKeyRange): Promise<StoreValue<DBTypes, StoreName>?>
    fun getAll(query: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally, count: Number = definedExternally): Promise<Array<StoreValue<DBTypes, StoreName>>>
    fun getAll(): Promise<Array<StoreValue<DBTypes, StoreName>>>
    fun getAll(query: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally): Promise<Array<StoreValue<DBTypes, StoreName>>>
    fun getAll(query: IDBKeyRange? = definedExternally, count: Number = definedExternally): Promise<Array<StoreValue<DBTypes, StoreName>>>
    fun getAll(query: IDBKeyRange? = definedExternally): Promise<Array<StoreValue<DBTypes, StoreName>>>
    fun getAllKeys(query: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally, count: Number = definedExternally): Promise<Array<StoreKey<DBTypes, StoreName>>>
    fun getAllKeys(): Promise<Array<StoreKey<DBTypes, StoreName>>>
    fun getAllKeys(query: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally): Promise<Array<StoreKey<DBTypes, StoreName>>>
    fun getAllKeys(query: IDBKeyRange? = definedExternally, count: Number = definedExternally): Promise<Array<StoreKey<DBTypes, StoreName>>>
    fun getAllKeys(query: IDBKeyRange? = definedExternally): Promise<Array<StoreKey<DBTypes, StoreName>>>
    fun getKey(query: IndexKey<DBTypes, StoreName, IndexName>): Promise<StoreKey<DBTypes, StoreName>?>
    fun getKey(query: IDBKeyRange): Promise<StoreKey<DBTypes, StoreName>?>
    fun openCursor(query: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): Promise<IDBPCursorWithValue<DBTypes, TxStores, StoreName, IndexName, Mode>?>
    fun openCursor(): Promise<IDBPCursorWithValue<DBTypes, TxStores, StoreName, IndexName, Mode>?>
    fun openCursor(query: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally): Promise<IDBPCursorWithValue<DBTypes, TxStores, StoreName, IndexName, Mode>?>
    fun openCursor(query: IDBKeyRange? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): Promise<IDBPCursorWithValue<DBTypes, TxStores, StoreName, IndexName, Mode>?>
    fun openCursor(query: IDBKeyRange? = definedExternally): Promise<IDBPCursorWithValue<DBTypes, TxStores, StoreName, IndexName, Mode>?>
    fun openKeyCursor(query: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): Promise<IDBPCursor<DBTypes, TxStores, StoreName, IndexName, Mode>?>
    fun openKeyCursor(): Promise<IDBPCursor<DBTypes, TxStores, StoreName, IndexName, Mode>?>
    fun openKeyCursor(query: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally): Promise<IDBPCursor<DBTypes, TxStores, StoreName, IndexName, Mode>?>
    fun openKeyCursor(query: IDBKeyRange? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): Promise<IDBPCursor<DBTypes, TxStores, StoreName, IndexName, Mode>?>
    fun openKeyCursor(query: IDBKeyRange? = definedExternally): Promise<IDBPCursor<DBTypes, TxStores, StoreName, IndexName, Mode>?>
    fun iterate(query: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): AsyncIterableIterator<IDBPCursorWithValueIteratorValue<DBTypes, TxStores, StoreName, IndexName, Mode>>
    fun iterate(): AsyncIterableIterator<IDBPCursorWithValueIteratorValue<DBTypes, TxStores, StoreName, IndexName, Mode>>
    fun iterate(query: IndexKey<DBTypes, StoreName, IndexName>? = definedExternally): AsyncIterableIterator<IDBPCursorWithValueIteratorValue<DBTypes, TxStores, StoreName, IndexName, Mode>>
    fun iterate(query: IDBKeyRange? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): AsyncIterableIterator<IDBPCursorWithValueIteratorValue<DBTypes, TxStores, StoreName, IndexName, Mode>>
    fun iterate(query: IDBKeyRange? = definedExternally): AsyncIterableIterator<IDBPCursorWithValueIteratorValue<DBTypes, TxStores, StoreName, IndexName, Mode>>
}

external interface IDBPIndex__0 : IDBPIndex<Any, ArrayLike<StoreNames<Any>>, StoreNames<Any>, IndexNames<Any, StoreNames<Any>>, String /* "readonly" */>

typealias IDBPCursorExtends = Omit<IDBCursor, String /* "key" | "primaryKey" | "source" | "advance" | "continue" | "continuePrimaryKey" | "delete" | "update" */>

external interface IDBPCursor<DBTypes, TxStores : ArrayLike<StoreNames<DBTypes>>, StoreName : StoreNames<DBTypes>, IndexName, Mode : String> : IDBPCursorExtends {
    var key: CursorKey<DBTypes, StoreName, IndexName>
    var primaryKey: StoreKey<DBTypes, StoreName>
    var source: CursorSource<DBTypes, TxStores, StoreName, IndexName, Mode>
    fun <T> advance(count: Number): Promise<T?>
    fun <T> `continue`(key: CursorKey<DBTypes, StoreName, IndexName> = definedExternally): Promise<T?>
    fun <T> continuePrimaryKey(key: CursorKey<DBTypes, StoreName, IndexName>, primaryKey: StoreKey<DBTypes, StoreName>): Promise<T?>
    var delete: Any
    var update: Any
}

typealias IDBPCursorIteratorValueExtends<DBTypes, TxStores, StoreName, IndexName, Mode> = Omit<IDBPCursor<DBTypes, TxStores, StoreName, IndexName, Mode>, String /* "advance" | "continue" | "continuePrimaryKey" */>

external interface IDBPCursorIteratorValue<DBTypes, TxStores : ArrayLike<StoreNames<DBTypes>>, StoreName : StoreNames<DBTypes>, IndexName, Mode : String> : IDBPCursorIteratorValueExtends<DBTypes, TxStores, StoreName, IndexName, Mode> {
    fun advance(count: Number)
    fun `continue`(key: CursorKey<DBTypes, StoreName, IndexName> = definedExternally)
    fun continuePrimaryKey(key: CursorKey<DBTypes, StoreName, IndexName>, primaryKey: StoreKey<DBTypes, StoreName>)
}

external interface IDBPCursorWithValue<DBTypes, TxStores : ArrayLike<StoreNames<DBTypes>>, StoreName : StoreNames<DBTypes>, IndexName, Mode : String> : IDBPCursor<DBTypes, TxStores, StoreName, IndexName, Mode> {
    var value: StoreValue<DBTypes, StoreName>
}

typealias IDBPCursorWithValueIteratorValueExtends<DBTypes, TxStores, StoreName, IndexName, Mode> = Omit<IDBPCursorWithValue<DBTypes, TxStores, StoreName, IndexName, Mode>, String /* "advance" | "continue" | "continuePrimaryKey" */>

external interface IDBPCursorWithValueIteratorValue<DBTypes, TxStores : ArrayLike<StoreNames<DBTypes>>, StoreName : StoreNames<DBTypes>, IndexName, Mode : String> : IDBPCursorWithValueIteratorValueExtends<DBTypes, TxStores, StoreName, IndexName, Mode> {
    fun advance(count: Number)
    fun `continue`(key: CursorKey<DBTypes, StoreName, IndexName> = definedExternally)
    fun continuePrimaryKey(key: CursorKey<DBTypes, StoreName, IndexName>, primaryKey: StoreKey<DBTypes, StoreName>)
}