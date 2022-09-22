import { Project } from 'ts-morph';
import {Function} from "./types";
import {CPPGenerator} from "./codegen/CPPGenerator";
import {parseSourceFile} from "./parser/Parser";


const generators = {
    cpp: {
        generator: new CPPGenerator(),
        path: ""
    }
}

export function compile(filePath: string) {
    const project = new Project();
    
    project.addSourceFileAtPath(filePath);
    project.getSourceFiles()
        .map(parseSourceFile)
        .forEach(parseResult => {
            const interfaces = parseResult?.success?.interfaces
            if (interfaces) {
                interfaces.forEach(contract => {
                    contract.functions
                        .map(generators.cpp.generator.generateFunction)
                        .forEach(i => i.success && console.log(i.success))
                })
            }
        })
}
