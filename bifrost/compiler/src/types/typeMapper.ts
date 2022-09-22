export type Language = "cpp" | "kotlin" | "objc"
export type TypeMap = {
    [type: string]: {
        [lang in Language]: string
    }
}

/*
All JSI types are primitives
Also define Arrays and Objects of these primitives
 */
export const types: TypeMap = {
    "number": { // support integer vs float later
        cpp: "double",
        kotlin: "Double",
        objc: "NSNumber"
    },
    "string": {
        cpp: "string",
        kotlin: "String",
        objc: "NSString"
    },
    "boolean": {
        cpp: "bool",
        kotlin: "Boolean",
        objc: "bool"
    },
    "null": {
        cpp: "nullptr",
        kotlin: "null",
        objc: "nil"
    },
    "undefined": {
        cpp: "void",
        kotlin: "",
        objc: ""
    }
}

export function getType(name: string, lang: Language): Partial<{ error: string, mappedType: string }> {
    const type = types[name];
    if (!type) return { error: "UNREGISTERED_TYPE" };

    const mappedType = type[lang];
    if (!mappedType) return { error: "UNMAPPED_LANGUAGE" };

    else return { mappedType };
}