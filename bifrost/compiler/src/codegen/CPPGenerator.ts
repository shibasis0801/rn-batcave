import {getType} from "../types/typeMapper";
import {ClassGenResult, CodeGenerator, FunctionGenResult, InterfaceGenResult} from "./CodeGenerator";
import {Function, DataClass, Interface} from "../types";

/*
Usage:
const cppGenerator = new CPPGenerator()
const cpp = cppGenerator.generateFunction({
    name: "helloWorld",
    params: [
        { name: "age", type: "number", referenceType: "const" },
    ],
    returnType: "undefined"
})
*/
function functionTemplate(returnType: string, name: string, argumentList: string) {
    return `
        ${returnType} ${name}(${argumentList}) {
                
        }`.replace(/  +/g, '')
}

export class CPPGenerator implements CodeGenerator {


    generateFunction(fn: Function): FunctionGenResult {
        const returnType = getType(fn.returnType, "cpp");
        const { error } = returnType;
        if (error) return { error };

        const { name } = fn;
        const argumentList = fn.params.map(param => {
            const { name, type, referenceType }  = param;
            const cppType = getType(type, "cpp")
            if (cppType.mappedType) {
                const ref = referenceType ? "&" : "";
                const modifier = referenceType == "const" ? "const " : "";

                return `${modifier}${cppType.mappedType} ${ref}${name}`
            }
            else return "Error error"
        }).join(", ")

        return { success: functionTemplate(returnType.mappedType!, name, argumentList) };
    }

    generateClass(cl: DataClass): ClassGenResult {
        return { error: "" };
    }

    generateInterface(f: Interface): InterfaceGenResult {
        return { error: "" }
    }
}
