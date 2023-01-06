@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package com.myntra.appscore.database.idb

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external interface IDBIndexParameters {
    var multiEntry: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var unique: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IDBObjectStoreParameters {
    var autoIncrement: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var keyPath: dynamic /* String? | Array<String>? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface IDBVersionChangeEventInit : EventInit {
    var newVersion: Number?
        get() = definedExternally
        set(value) = definedExternally
    var oldVersion: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface DOMException {
    var code: Number
    var message: String
    var name: String
    var ABORT_ERR: Number
    var DATA_CLONE_ERR: Number
    var DOMSTRING_SIZE_ERR: Number
    var HIERARCHY_REQUEST_ERR: Number
    var INDEX_SIZE_ERR: Number
    var INUSE_ATTRIBUTE_ERR: Number
    var INVALID_ACCESS_ERR: Number
    var INVALID_CHARACTER_ERR: Number
    var INVALID_MODIFICATION_ERR: Number
    var INVALID_NODE_TYPE_ERR: Number
    var INVALID_STATE_ERR: Number
    var NAMESPACE_ERR: Number
    var NETWORK_ERR: Number
    var NOT_FOUND_ERR: Number
    var NOT_SUPPORTED_ERR: Number
    var NO_DATA_ALLOWED_ERR: Number
    var NO_MODIFICATION_ALLOWED_ERR: Number
    var QUOTA_EXCEEDED_ERR: Number
    var SECURITY_ERR: Number
    var SYNTAX_ERR: Number
    var TIMEOUT_ERR: Number
    var TYPE_MISMATCH_ERR: Number
    var URL_MISMATCH_ERR: Number
    var VALIDATION_ERR: Number
    var WRONG_DOCUMENT_ERR: Number
}

external interface DOMStringList {
    var length: Number
    fun contains(string: String): Boolean
    fun item(index: Number): String?
    @nativeGetter
    operator fun get(index: Number): String?
    @nativeSetter
    operator fun set(index: Number, value: String)
}

external interface EventListenerObject {
    fun handleEvent(evt: Event)
}

typealias IDBArrayKey = Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>

external interface IDBCursor {
    var direction: String /* "next" | "nextunique" | "prev" | "prevunique" */
    var key: dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */
        get() = definedExternally
        set(value) = definedExternally
    var primaryKey: dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */
        get() = definedExternally
        set(value) = definedExternally
    var source: dynamic /* IDBObjectStore | IDBIndex */
        get() = definedExternally
        set(value) = definedExternally
    fun advance(count: Number)
    fun `continue`(key: Number = definedExternally)
    fun `continue`()
    fun `continue`(key: String = definedExternally)
    fun `continue`(key: Date = definedExternally)
    fun `continue`(key: ArrayBufferView = definedExternally)
    fun `continue`(key: ArrayBuffer = definedExternally)
    fun `continue`(key: IDBArrayKey = definedExternally)
    fun continuePrimaryKey(key: Number, primaryKey: Any /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */)
    fun continuePrimaryKey(key: String, primaryKey: Any /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */)
    fun continuePrimaryKey(key: Date, primaryKey: Any /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */)
    fun continuePrimaryKey(key: ArrayBufferView, primaryKey: Any /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */)
    fun continuePrimaryKey(key: ArrayBuffer, primaryKey: Any /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */)
    fun continuePrimaryKey(key: IDBArrayKey, primaryKey: Any /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */)
    fun delete(): IDBRequest<Nothing?>
    fun update(value: Any): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
}

external interface IDBCursorWithValue : IDBCursor {
    var value: Any
}

external interface IDBDatabaseEventMap {
    var abort: Event
    var close: Event
    var error: Event
    var versionchange: IDBVersionChangeEvent
}

external interface IDBDatabase : EventTarget {
    var name: String
    var objectStoreNames: DOMStringList
    var onabort: ((self: IDBDatabase, ev: Event) -> Any)?
    var onclose: ((self: IDBDatabase, ev: Event) -> Any)?
    var onerror: ((self: IDBDatabase, ev: Event) -> Any)?
    var onversionchange: ((self: IDBDatabase, ev: IDBVersionChangeEvent) -> Any)?
    var version: Number
    fun close()
    fun createObjectStore(name: String, optionalParameters: IDBObjectStoreParameters = definedExternally): IDBObjectStore
    fun deleteObjectStore(name: String)
    fun transaction(storeNames: String, mode: String /* "readonly" | "readwrite" | "versionchange" */ = definedExternally): IDBTransaction
    fun transaction(storeNames: String): IDBTransaction
    fun transaction(storeNames: Array<String>, mode: String /* "readonly" | "readwrite" | "versionchange" */ = definedExternally): IDBTransaction
    fun transaction(storeNames: Array<String>): IDBTransaction
    fun <K : String> addEventListener(type: K, listener: (self: IDBDatabase, ev: Any) -> Any, options: Boolean = definedExternally)
    fun <K : String> addEventListener(type: K, listener: (self: IDBDatabase, ev: Any) -> Any)
    fun <K : String> addEventListener(type: K, listener: (self: IDBDatabase, ev: Any) -> Any, options: AddEventListenerOptions = definedExternally)
    fun addEventListener(type: String, listener: EventListener, options: Boolean = definedExternally)
    override fun addEventListener(type: String, listener: EventListener?, options: Boolean)
    fun addEventListener(type: String, listener: EventListener)
    fun addEventListener(type: String, listener: EventListener?)
    fun addEventListener(type: String, listener: EventListener, options: AddEventListenerOptions = definedExternally)
    override fun addEventListener(type: String, listener: EventListener?, options: AddEventListenerOptions)
    fun addEventListener(type: String, listener: EventListenerObject, options: Boolean = definedExternally)
    fun addEventListener(type: String, listener: EventListenerObject?, options: Boolean)
    fun addEventListener(type: String, listener: EventListenerObject)
    fun addEventListener(type: String, listener: EventListenerObject?)
    fun addEventListener(type: String, listener: EventListenerObject, options: AddEventListenerOptions = definedExternally)
    fun addEventListener(type: String, listener: EventListenerObject?, options: AddEventListenerOptions)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBDatabase, ev: Any) -> Any, options: Boolean = definedExternally)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBDatabase, ev: Any) -> Any)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBDatabase, ev: Any) -> Any, options: EventListenerOptions = definedExternally)
    fun removeEventListener(type: String, listener: EventListener, options: Boolean = definedExternally)
    override fun removeEventListener(type: String, callback: EventListener?, options: Boolean)
    fun removeEventListener(type: String, listener: EventListener)
    fun removeEventListener(type: String, callback: EventListener?)
    fun removeEventListener(type: String, listener: EventListener, options: EventListenerOptions = definedExternally)
    override fun removeEventListener(type: String, callback: EventListener?, options: EventListenerOptions)
    fun removeEventListener(type: String, listener: EventListenerObject, options: Boolean = definedExternally)
    fun removeEventListener(type: String, callback: EventListenerObject?, options: Boolean)
    fun removeEventListener(type: String, listener: EventListenerObject)
    fun removeEventListener(type: String, callback: EventListenerObject?)
    fun removeEventListener(type: String, listener: EventListenerObject, options: EventListenerOptions = definedExternally)
    fun removeEventListener(type: String, callback: EventListenerObject?, options: EventListenerOptions)
}

external interface IDBIndex {
    var keyPath: dynamic /* String | Array<String> */
        get() = definedExternally
        set(value) = definedExternally
    var multiEntry: Boolean
    var name: String
    var objectStore: IDBObjectStore
    var unique: Boolean
    fun count(key: Number = definedExternally): IDBRequest<Number>
    fun count(): IDBRequest<Number>
    fun count(key: String = definedExternally): IDBRequest<Number>
    fun count(key: Date = definedExternally): IDBRequest<Number>
    fun count(key: ArrayBufferView = definedExternally): IDBRequest<Number>
    fun count(key: ArrayBuffer = definedExternally): IDBRequest<Number>
    fun count(key: IDBArrayKey = definedExternally): IDBRequest<Number>
    fun count(key: IDBKeyRange = definedExternally): IDBRequest<Number>
    fun get(key: Number): IDBRequest<Any?>
    fun get(key: String): IDBRequest<Any?>
    fun get(key: Date): IDBRequest<Any?>
    fun get(key: ArrayBufferView): IDBRequest<Any?>
    fun get(key: ArrayBuffer): IDBRequest<Any?>
    fun get(key: IDBArrayKey): IDBRequest<Any?>
    fun get(key: IDBKeyRange): IDBRequest<Any?>
    fun getAll(query: Number? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(): IDBRequest<Array<Any>>
    fun getAll(query: Number? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: String? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: String? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: Date? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: Date? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: ArrayBufferView? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: ArrayBufferView? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: ArrayBuffer? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: ArrayBuffer? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: IDBArrayKey? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: IDBArrayKey? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: IDBKeyRange? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: IDBKeyRange? = definedExternally): IDBRequest<Array<Any>>
    fun getAllKeys(query: Number? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: Number? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: String? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: String? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: Date? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: Date? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: ArrayBufferView? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: ArrayBufferView? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: ArrayBuffer? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: ArrayBuffer? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: IDBArrayKey? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: IDBArrayKey? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: IDBKeyRange? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: IDBKeyRange? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getKey(key: Number): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(key: String): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(key: Date): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(key: ArrayBufferView): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(key: ArrayBuffer): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(key: IDBArrayKey): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(key: IDBKeyRange): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun openCursor(query: Number? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: Number? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: String? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: String? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: Date? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: Date? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: ArrayBufferView? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: ArrayBufferView? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: ArrayBuffer? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: ArrayBuffer? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: IDBArrayKey? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: IDBArrayKey? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: IDBKeyRange? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: IDBKeyRange? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openKeyCursor(query: Number? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: Number? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: String? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: String? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: Date? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: Date? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: ArrayBufferView? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: ArrayBufferView? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: ArrayBuffer? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: ArrayBuffer? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: IDBArrayKey? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: IDBArrayKey? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: IDBKeyRange? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: IDBKeyRange? = definedExternally): IDBRequest<IDBCursor?>
}

external interface IDBKeyRange {
    var lower: Any
    var lowerOpen: Boolean
    var upper: Any
    var upperOpen: Boolean
    fun includes(key: Any): Boolean
}

external interface IDBObjectStore {
    fun createIndex(name: String, keyPath: String, options: IDBIndexParameters = definedExternally): IDBIndex
    fun createIndex(name: String, keyPath: String): IDBIndex
    fun createIndex(name: String, keyPath: Iterable<String>, options: IDBIndexParameters = definedExternally): IDBIndex
    fun createIndex(name: String, keyPath: Iterable<String>): IDBIndex
    var autoIncrement: Boolean
    var indexNames: DOMStringList
    var keyPath: dynamic /* String | Array<String> */
        get() = definedExternally
        set(value) = definedExternally
    var name: String
    var transaction: IDBTransaction
    fun add(value: Any, key: Number = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun add(value: Any): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun add(value: Any, key: String = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun add(value: Any, key: Date = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun add(value: Any, key: ArrayBufferView = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun add(value: Any, key: ArrayBuffer = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun add(value: Any, key: IDBArrayKey = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun clear(): IDBRequest<Nothing?>
    fun count(key: Number = definedExternally): IDBRequest<Number>
    fun count(): IDBRequest<Number>
    fun count(key: String = definedExternally): IDBRequest<Number>
    fun count(key: Date = definedExternally): IDBRequest<Number>
    fun count(key: ArrayBufferView = definedExternally): IDBRequest<Number>
    fun count(key: ArrayBuffer = definedExternally): IDBRequest<Number>
    fun count(key: IDBArrayKey = definedExternally): IDBRequest<Number>
    fun count(key: IDBKeyRange = definedExternally): IDBRequest<Number>
    fun createIndex(name: String, keyPath: Array<String>, options: IDBIndexParameters = definedExternally): IDBIndex
    fun createIndex(name: String, keyPath: Array<String>): IDBIndex
    fun delete(key: Number): IDBRequest<Nothing?>
    fun delete(key: String): IDBRequest<Nothing?>
    fun delete(key: Date): IDBRequest<Nothing?>
    fun delete(key: ArrayBufferView): IDBRequest<Nothing?>
    fun delete(key: ArrayBuffer): IDBRequest<Nothing?>
    fun delete(key: IDBArrayKey): IDBRequest<Nothing?>
    fun delete(key: IDBKeyRange): IDBRequest<Nothing?>
    fun deleteIndex(name: String)
    fun get(query: Number): IDBRequest<Any?>
    fun get(query: String): IDBRequest<Any?>
    fun get(query: Date): IDBRequest<Any?>
    fun get(query: ArrayBufferView): IDBRequest<Any?>
    fun get(query: ArrayBuffer): IDBRequest<Any?>
    fun get(query: IDBArrayKey): IDBRequest<Any?>
    fun get(query: IDBKeyRange): IDBRequest<Any?>
    fun getAll(query: Number? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(): IDBRequest<Array<Any>>
    fun getAll(query: Number? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: String? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: String? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: Date? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: Date? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: ArrayBufferView? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: ArrayBufferView? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: ArrayBuffer? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: ArrayBuffer? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: IDBArrayKey? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: IDBArrayKey? = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: IDBKeyRange? = definedExternally, count: Number = definedExternally): IDBRequest<Array<Any>>
    fun getAll(query: IDBKeyRange? = definedExternally): IDBRequest<Array<Any>>
    fun getAllKeys(query: Number? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: Number? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: String? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: String? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: Date? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: Date? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: ArrayBufferView? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: ArrayBufferView? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: ArrayBuffer? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: ArrayBuffer? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: IDBArrayKey? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: IDBArrayKey? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: IDBKeyRange? = definedExternally, count: Number = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getAllKeys(query: IDBKeyRange? = definedExternally): IDBRequest<Array<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>>
    fun getKey(query: Number): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(query: String): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(query: Date): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(query: ArrayBufferView): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(query: ArrayBuffer): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(query: IDBArrayKey): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun getKey(query: IDBKeyRange): IDBRequest<dynamic /* Number? | String? | Date? | ArrayBufferView? | ArrayBuffer? | IDBArrayKey? */>
    fun index(name: String): IDBIndex
    fun openCursor(query: Number? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: Number? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: String? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: String? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: Date? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: Date? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: ArrayBufferView? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: ArrayBufferView? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: ArrayBuffer? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: ArrayBuffer? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: IDBArrayKey? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: IDBArrayKey? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: IDBKeyRange? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openCursor(query: IDBKeyRange? = definedExternally): IDBRequest<IDBCursorWithValue?>
    fun openKeyCursor(query: Number? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: Number? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: String? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: String? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: Date? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: Date? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: ArrayBufferView? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: ArrayBufferView? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: ArrayBuffer? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: ArrayBuffer? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: IDBArrayKey? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: IDBArrayKey? = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: IDBKeyRange? = definedExternally, direction: String /* "next" | "nextunique" | "prev" | "prevunique" */ = definedExternally): IDBRequest<IDBCursor?>
    fun openKeyCursor(query: IDBKeyRange? = definedExternally): IDBRequest<IDBCursor?>
    fun put(value: Any, key: Number = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun put(value: Any): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun put(value: Any, key: String = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun put(value: Any, key: Date = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun put(value: Any, key: ArrayBufferView = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun put(value: Any, key: ArrayBuffer = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
    fun put(value: Any, key: IDBArrayKey = definedExternally): IDBRequest<dynamic /* Number | String | Date | ArrayBufferView | ArrayBuffer | IDBArrayKey */>
}

external interface IDBOpenDBRequestEventMap : IDBRequestEventMap {
    var blocked: Event
    var upgradeneeded: IDBVersionChangeEvent
}

external interface IDBOpenDBRequest : IDBRequest<IDBDatabase> {
    var onblocked: ((self: IDBOpenDBRequest, ev: Event) -> Any)?
    var onupgradeneeded: ((self: IDBOpenDBRequest, ev: IDBVersionChangeEvent) -> Any)?
    fun <K : String> addEventListener(type: K, listener: (self: IDBOpenDBRequest, ev: Any) -> Any, options: Boolean = definedExternally)
    fun <K : String> addEventListener(type: K, listener: (self: IDBOpenDBRequest, ev: Any) -> Any)
    fun <K : String> addEventListener(type: K, listener: (self: IDBOpenDBRequest, ev: Any) -> Any, options: AddEventListenerOptions = definedExternally)
    override fun addEventListener(type: String, listener: EventListener, options: Boolean)
    override fun addEventListener(type: String, listener: EventListener)
    override fun addEventListener(type: String, listener: EventListener, options: AddEventListenerOptions)
    override fun addEventListener(type: String, listener: EventListenerObject, options: Boolean)
    override fun addEventListener(type: String, listener: EventListenerObject)
    override fun addEventListener(type: String, listener: EventListenerObject, options: AddEventListenerOptions)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBOpenDBRequest, ev: Any) -> Any, options: Boolean = definedExternally)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBOpenDBRequest, ev: Any) -> Any)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBOpenDBRequest, ev: Any) -> Any, options: EventListenerOptions = definedExternally)
    override fun removeEventListener(type: String, listener: EventListener, options: Boolean)
    override fun removeEventListener(type: String, listener: EventListener)
    override fun removeEventListener(type: String, listener: EventListener, options: EventListenerOptions)
    override fun removeEventListener(type: String, listener: EventListenerObject, options: Boolean)
    override fun removeEventListener(type: String, listener: EventListenerObject)
    override fun removeEventListener(type: String, listener: EventListenerObject, options: EventListenerOptions)
}

external interface IDBRequestEventMap {
    var error: Event
    var success: Event
}

external interface IDBRequest<T> : EventTarget {
    var error: DOMException?
    var onerror: ((self: IDBRequest<T>, ev: Event) -> Any)?
    var onsuccess: ((self: IDBRequest<T>, ev: Event) -> Any)?
    var readyState: String /* "done" | "pending" */
    var result: T
    var source: dynamic /* IDBObjectStore | IDBIndex | IDBCursor */
        get() = definedExternally
        set(value) = definedExternally
    var transaction: IDBTransaction?
    fun <K : String> addEventListener(type: K, listener: (self: IDBRequest<T>, ev: Any) -> Any, options: Boolean = definedExternally)
    fun <K : String> addEventListener(type: K, listener: (self: IDBRequest<T>, ev: Any) -> Any)
    fun <K : String> addEventListener(type: K, listener: (self: IDBRequest<T>, ev: Any) -> Any, options: AddEventListenerOptions = definedExternally)
    fun addEventListener(type: String, listener: EventListener, options: Boolean = definedExternally)
    override fun addEventListener(type: String, listener: EventListener?, options: Boolean)
    fun addEventListener(type: String, listener: EventListener)
    fun addEventListener(type: String, listener: EventListener?)
    fun addEventListener(type: String, listener: EventListener, options: AddEventListenerOptions = definedExternally)
    override fun addEventListener(type: String, listener: EventListener?, options: AddEventListenerOptions)
    fun addEventListener(type: String, listener: EventListenerObject, options: Boolean = definedExternally)
    fun addEventListener(type: String, listener: EventListenerObject?, options: Boolean)
    fun addEventListener(type: String, listener: EventListenerObject)
    fun addEventListener(type: String, listener: EventListenerObject?)
    fun addEventListener(type: String, listener: EventListenerObject, options: AddEventListenerOptions = definedExternally)
    fun addEventListener(type: String, listener: EventListenerObject?, options: AddEventListenerOptions)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBRequest<T>, ev: Any) -> Any, options: Boolean = definedExternally)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBRequest<T>, ev: Any) -> Any)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBRequest<T>, ev: Any) -> Any, options: EventListenerOptions = definedExternally)
    fun removeEventListener(type: String, listener: EventListener, options: Boolean = definedExternally)
    override fun removeEventListener(type: String, callback: EventListener?, options: Boolean)
    fun removeEventListener(type: String, listener: EventListener)
    fun removeEventListener(type: String, callback: EventListener?)
    fun removeEventListener(type: String, listener: EventListener, options: EventListenerOptions = definedExternally)
    override fun removeEventListener(type: String, callback: EventListener?, options: EventListenerOptions)
    fun removeEventListener(type: String, listener: EventListenerObject, options: Boolean = definedExternally)
    fun removeEventListener(type: String, callback: EventListenerObject?, options: Boolean)
    fun removeEventListener(type: String, listener: EventListenerObject)
    fun removeEventListener(type: String, callback: EventListenerObject?)
    fun removeEventListener(type: String, listener: EventListenerObject, options: EventListenerOptions = definedExternally)
    fun removeEventListener(type: String, callback: EventListenerObject?, options: EventListenerOptions)
}

external interface IDBTransactionEventMap {
    var abort: Event
    var complete: Event
    var error: Event
}

external interface IDBTransaction : EventTarget {
    var db: IDBDatabase
    var error: DOMException
    var mode: String /* "readonly" | "readwrite" | "versionchange" */
    var objectStoreNames: DOMStringList
    var onabort: ((self: IDBTransaction, ev: Event) -> Any)?
    var oncomplete: ((self: IDBTransaction, ev: Event) -> Any)?
    var onerror: ((self: IDBTransaction, ev: Event) -> Any)?
    fun abort()
    fun objectStore(name: String): IDBObjectStore
    fun <K : String> addEventListener(type: K, listener: (self: IDBTransaction, ev: Any) -> Any, options: Boolean = definedExternally)
    fun <K : String> addEventListener(type: K, listener: (self: IDBTransaction, ev: Any) -> Any)
    fun <K : String> addEventListener(type: K, listener: (self: IDBTransaction, ev: Any) -> Any, options: AddEventListenerOptions = definedExternally)
    fun addEventListener(type: String, listener: EventListener, options: Boolean = definedExternally)
    override fun addEventListener(type: String, listener: EventListener?, options: Boolean)
    fun addEventListener(type: String, listener: EventListener)
    fun addEventListener(type: String, listener: EventListener?)
    fun addEventListener(type: String, listener: EventListener, options: AddEventListenerOptions = definedExternally)
    override fun addEventListener(type: String, listener: EventListener?, options: AddEventListenerOptions)
    fun addEventListener(type: String, listener: EventListenerObject, options: Boolean = definedExternally)
    fun addEventListener(type: String, listener: EventListenerObject?, options: Boolean)
    fun addEventListener(type: String, listener: EventListenerObject)
    fun addEventListener(type: String, listener: EventListenerObject?)
    fun addEventListener(type: String, listener: EventListenerObject, options: AddEventListenerOptions = definedExternally)
    fun addEventListener(type: String, listener: EventListenerObject?, options: AddEventListenerOptions)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBTransaction, ev: Any) -> Any, options: Boolean = definedExternally)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBTransaction, ev: Any) -> Any)
    fun <K : String> removeEventListener(type: K, listener: (self: IDBTransaction, ev: Any) -> Any, options: EventListenerOptions = definedExternally)
    fun removeEventListener(type: String, listener: EventListener, options: Boolean = definedExternally)
    override fun removeEventListener(type: String, callback: EventListener?, options: Boolean)
    fun removeEventListener(type: String, listener: EventListener)
    fun removeEventListener(type: String, callback: EventListener?)
    fun removeEventListener(type: String, listener: EventListener, options: EventListenerOptions = definedExternally)
    override fun removeEventListener(type: String, callback: EventListener?, options: EventListenerOptions)
    fun removeEventListener(type: String, listener: EventListenerObject, options: Boolean = definedExternally)
    fun removeEventListener(type: String, callback: EventListenerObject?, options: Boolean)
    fun removeEventListener(type: String, listener: EventListenerObject)
    fun removeEventListener(type: String, callback: EventListenerObject?)
    fun removeEventListener(type: String, listener: EventListenerObject, options: EventListenerOptions = definedExternally)
    fun removeEventListener(type: String, callback: EventListenerObject?, options: EventListenerOptions)
}

external interface IDBVersionChangeEvent : Event {
    var newVersion: Number?
    var oldVersion: Number
}