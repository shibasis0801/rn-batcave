package com.myntra.appscore.batcave
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

@Serializable
data class Address(
    val flatNumber: Int = 5141,
    val floor: Int = 14,
    val block: String = "5",
    val apartment: String = "PFR",
    val area: String = "Harlur",
    val city: String = "Bangalore"
)

object ProtobufSerializer {
    @OptIn(ExperimentalSerializationApi::class)
    inline fun <reified T> getBytes(data: T) = ProtoBuf.encodeToByteArray(data)

    @OptIn(ExperimentalSerializationApi::class)
    inline fun<reified T> fromBytes(byteArray: ByteArray) = ProtoBuf.decodeFromByteArray<T>(byteArray)
}

@Serializable
data class Person(
    val name: String = "Shibasis",
    val age: Int = 26,
    val address: Address = Address()
)


val dataForTransferOverJSI = Person()

@OptIn(ExperimentalSerializationApi::class, InternalSerializationApi::class)
fun getSchemaString(clazz: KClass<*>): String {
    val serializer = clazz.serializer()
    return ProtoBufSchemaGenerator.generateSchemaText(serializer.descriptor)
}