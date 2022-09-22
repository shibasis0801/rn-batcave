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

    getDouble(index: Number): Number
    getLong(index: Number): Number
    getString(index: Number): string
    getBytes(index: Number): ArrayBuffer

    close(): void
}


