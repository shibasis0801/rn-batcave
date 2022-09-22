import {Function, DataClass, Result, Interface} from "../types";
export type FunctionGenResult = Result<string>
export type ClassGenResult = Result<string>
export type InterfaceGenResult = Result<string>

export interface CodeGenerator {
    generateClass(cl: DataClass): ClassGenResult
    generateFunction(fn: Function): FunctionGenResult
    generateInterface(contract: Interface): InterfaceGenResult
}