type Nullable<T> = T | null | undefined
declare const __doNotImplementIt: unique symbol
type __doNotImplementIt = typeof __doNotImplementIt
export namespace com.myntra.appscore {
    function helloWorld(message: string): string;
    class Greeting {
        constructor();
        greeting(): string;
    }
}
export namespace com.myntra.appscore {
    class Test {
        constructor(name: string);
        get name(): string;
        static get Companion(): {
            serializer(): any/* kotlinx.serialization.KSerializer<com.myntra.appscore.Test> */;
        };
        static get $serializer(): {
        } & any/* kotlinx.serialization.internal.GeneratedSerializer<com.myntra.appscore.Test> */;
        component1(): string;
        copy(name?: string): com.myntra.appscore.Test;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        static Test_init_$Create$(seen1: number, name: Nullable<string>, serializationConstructorMarker: any/* Nullable<kotlinx.serialization.internal.SerializationConstructorMarker> */): com.myntra.appscore.Test;
    }
}
export namespace com.myntra.appscore.database {
    function helloSQL(): void;
}
export as namespace batcave;