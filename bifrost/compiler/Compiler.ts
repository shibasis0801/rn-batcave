import { Project } from 'ts-morph';

type TypeTargets = Partial<{ cpp: string, objc: string, kotlin: string }>
type TypeMap = { [key: string]: TypeTargets }

/*
All JSI types are primitives
Also define Arrays and Objects of these primitives
 */
const types: TypeMap = {
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
} as const

// type JSType = keyof typeof types
const typeNames = Object.keys(types)
type JSType = typeof typeNames[number]


export type Param = {
    name: string,
    type: JSType | Class,
    referenceType?: "normal" | "const"
}

export type Class = {
    [key: string]: JSType | Class
}

/*
Variable Name becomes the class name in generated code.
 */
const Record: Class = {
    name: "string",
    age: "number",
    student: {
        roll: "number",
    }
}

export interface Function {
    name: string,
    params: Param[]
    returnType: string
}


export interface CodeGenerator {
    generateFunction(fn: Function): string,
    generateClass(cl: Class): string
}

export class CPPGenerator implements CodeGenerator {
    private type = (datatype: string) => types[datatype].cpp || "ERROR"

    private functionTemplate(returnType: string, name: string, argumentList: string) {
        return `
        ${returnType} ${name}(${argumentList}) {
                
        }`.replace(/  +/g, '')
    }

    generateFunction(fn: Function): string {
        const returnType = this.type(fn.returnType)
        const { name } = fn;
        const argumentList = fn.params.map(param => {
            const { name, type, referenceType }  = param;
            if (typeof type === "string" && typeNames.includes(type)) {
                const cppType = this.type(type);
                const ref = referenceType ? "&" : "";
                const modifier = referenceType == "const" ? "const " : "";

                return `${modifier}${cppType} ${ref}${name}`
            }
            return ""
        }).join(", ")

        return this.functionTemplate(returnType, name, argumentList);
    }

    generateClass(cl: Class): string {
        return "";
    }


}


const cppGenerator = new CPPGenerator()
const cpp = cppGenerator.generateFunction({
    name: "helloWorld",
    params: [
        { name: "age", type: "number", referenceType: "const" },
        { name: "roll", type: "number" },
        { name: "name", type: "string", referenceType: "const" }
    ],
    returnType: "undefined"
})
console.log(cpp);


const project = new Project();
project.addSourceFileAtPath("../../contract/SQL.ts");
project.getSourceFiles()
    .forEach(sourceFile => {
        const fns: Function[] = [];
        sourceFile.getInterfaces()
            .forEach(contract => {
                contract?.getStructure()?.methods?.forEach(method => {
                    console.log(method)
                    fns.push({
                        name: method.name,
                        returnType: method.returnType as any as string,
                        params: method.parameters?.map(param => ({
                            name: param.name,
                            type: param.type as any as string,
                        })) || []
                    })
                })
            })
        fns.map(fn => cppGenerator.generateFunction(fn))
            .forEach(fn => console.log(fn))
    })
