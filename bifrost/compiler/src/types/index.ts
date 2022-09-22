export type Result<T> = Partial<{ error: string, success: T }>

export type Param = {
    name: string,
    type: string,
    referenceType?: "normal" | "const"
}

export type DataClass = {
    [key: string]: string | DataClass
}

export interface Function {
    name: string,
    params: Param[]
    returnType: string
}

export interface Interface {
    name: string,
    functions: Function[]
}