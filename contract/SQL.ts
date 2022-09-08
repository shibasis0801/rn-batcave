export interface SQL {
    query(queryString: string): Cursor
}

interface Size {
    label: string,
    sellers: string[]
    prices: number[]
    isAvailable: boolean
}

interface Product {
    styleID: string
    sizes: Size[]
}

export type CursorTransformer<T> = (cursor: Cursor) => T

export interface CursorTransform {
    fromRow<T>(cursor: Cursor): T
}

const cursorTransformers: {
    [key: string]: CursorTransformer<any>
} = {
    product(cursor: Cursor): Product {
        return {
            styleID: cursor.getString(1),
            sizes: JSON.parse(cursor.getString(2))
        }
    }
}

export interface Cursor {
    next(): boolean

    getDouble(index: Number): Number
    getLong(index: Number): Number
    getString(index: Number): string
    getBytes(index: Number): ArrayBuffer

    close(): void
}

