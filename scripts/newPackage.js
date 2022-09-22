const fs = require("fs");
const os = require("os");
const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout
});

const kmmModule = name => `kmm/${name}/src`
const packagePrefix = "com.myntra.appscore"
const sourceSetPrefix = "kotlin/" + packagePrefix.split(".").join( "/")
const capitalize = s=> s[0].toUpperCase() + s.slice(1);
console.log(process.cwd(), kmmModule("core"));

const moduleName = process.argv[2];
const packageName = process.argv[3];

let mode = process.argv[4]
if (mode !== "DELETE") mode = "CREATE"

if (!moduleName || !packageName) {
    console.error("Wrong usage, do: \nyarn newPackage <module> <packageName>")
    process.exit(1)
}
const fileName = capitalize(packageName)
const packageLine = `package ${packagePrefix}.${packageName}`

const interfaceTemplate = `${packageLine}

interface I${fileName} {
    fun hello(): String
} 
`;

const classTemplate = sourceSet => `${packageLine}

class ${fileName}: I${fileName} {
    override fun hello(): String = "${sourceSet}"
}
`

const moduleSrc = kmmModule(moduleName)
if (mode === "CREATE") {
    fs.readdirSync(moduleSrc)
        .forEach(sourceSet => {
            const path = [moduleSrc, sourceSet, sourceSetPrefix, packageName].join("/")
            fs.mkdirSync(path)
            const filePath = `${path}/${fileName}.kt`;
            if (sourceSet === "commonMain")
                fs.writeFileSync(filePath, interfaceTemplate)
            else
                fs.writeFileSync(filePath, classTemplate(sourceSet))

            console.log(`Created package at ${path}`)
            console.log(`Wrote ${filePath}`)
        })
}
else {
    fs.readdirSync(moduleSrc)
        .forEach(sourceSet => {
            const path = [moduleSrc, sourceSet, sourceSetPrefix, packageName].join("/")
            readline.question(`Delete everything in ${path} y/N ?`, answer => {
                if (answer === "y") {
                    fs.rmSync(path, { recursive: true, force: true });
                    console.log("Done")
                }
                readline.close()
            });

        })
}

process.exit(0)
readline.on('close', () => process.exit(0));
