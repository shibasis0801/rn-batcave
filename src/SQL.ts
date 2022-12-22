export interface babySQL {
    rawQuery(query: string): string,
    cursor: {
        next(): string
    }
}

export interface SQL {
    query(queryString: string): Cursor
}

export interface Cursor {
    next(): boolean
    getString(index: Number): string
    getBytes(index: Number): ArrayBuffer
    close(): void
}


/*
Total 25 days
for KMM -> +7
for Web -> +10
( web does not have sql, so will use dexie.js which is non-relational but offers sql-like interface )
JSI Sqlite layer -> 10 days
Schema, Types & Migration support -> 8 days
LRU Cache -> 7 days



KMM -> 7 days
Dexie.js integration (web) -> 10

*/


/*
Android
SDK Java -> SQLiteOpen / Room
NDK C++ -> sqlite -> ndk
https://github.com/ospfranco/react-native-quick-sqlite -> Bundles SQL along -> adds 9mb
C++ -> JSI
JNI Wrapper to call Java SQL -> no size increase, jsi


iOS
sqlite3
objective c wrapper

web
sql.js -> Bundles SQL along -> adds 1 mb
dexie.js



android -> JNI (Java SQLite)
ios -> sqlite3
web -> dexie (sqlike) (tradeoffs -> no complex queries) schema migrations



Bridge -> JS < JSON > Native
JSI -> Native thread access to JS engine

Flutter -> MethodChannel (EventBus)  ( Binary ) ( sync / async )


Implement native modules
1
Bridge

2
JSI libraries mmkv
3
JSI bindings ourselves
4
JSI codegen -> RN
5
BinaryEventBus



android, ios, web

-> RN (fabric) (vgood at ui, not at platform)
-> KMM (Cash app)
-> JSI (vgood to transfer, business logic in c++)
-> NativeScript






 */





