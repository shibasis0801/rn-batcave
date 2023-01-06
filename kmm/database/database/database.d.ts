type Nullable<T> = T | null | undefined
declare const __doNotImplementIt: unique symbol
type __doNotImplementIt = typeof __doNotImplementIt
export namespace com.myntra.appscore.database {
    class Test {
        constructor(name: string);
        get name(): string;
        component1(): string;
        copy(name?: string): com.myntra.appscore.database.Test;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        static Test_init_$Create$(seen1: number, name: Nullable<string>, serializationConstructorMarker: any/* Nullable<kotlinx.serialization.internal.SerializationConstructorMarker> */): com.myntra.appscore.database.Test;
        static get Companion(): {
            serializer(): any/* kotlinx.serialization.KSerializer<com.myntra.appscore.database.Test> */;
        };
        static get $serializer(): {
        } & any/* kotlinx.serialization.internal.GeneratedSerializer<com.myntra.appscore.database.Test> */;
    }
}
export namespace com.myntra.appscore.database {
    class WebDatabase {
        constructor(name: string);
        get name(): string;
        test(): Promise<string>;
    }
}
export as namespace database;