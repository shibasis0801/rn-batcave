import {DataClass, Function, Interface, Result} from "../types";
import {
    InterfaceDeclaration,
    MethodSignatureStructure,
    OptionalKind,
    SourceFile
} from 'ts-morph';

export type ParseResult = Result<Partial<{
    classes: DataClass[],
    interfaces: Interface[]
}>>


function parseMethod(method: OptionalKind<MethodSignatureStructure>): Function {
    return {
        name: method.name,
        returnType: (method.returnType || "") as string,
        params: method.parameters?.map(param => ({
            name: param.name,
            type: param.type as any as string,
        })) || []
    }
}

function parseInterface(contract: InterfaceDeclaration): Interface {
    return {
        name: contract.getName(),
        functions: contract.getStructure()?.methods?.map(parseMethod) || []
    }
}

export function parseSourceFile(sourceFile: SourceFile): ParseResult {
    return {
        success: {
            interfaces: sourceFile.getInterfaces().map(parseInterface)
        }
    }
} 


