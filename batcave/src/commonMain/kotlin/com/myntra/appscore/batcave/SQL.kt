package com.myntra.appscore.batcave

interface ISQL {
    fun query(queryString: String): ICursor
}

interface ICursor {
    fun next(): Boolean

    fun getDouble(index: Double): Double
    fun getLong(index: Double): Double
    fun getString(index: Double): String
    fun getBytes(index: Double): ByteArray

    fun close(): Unit
}


class SQL : ISQL {
    override fun query(queryString: String): ICursor {
        TODO("Not yet implemented")
    }
}

class Cursor: ICursor {
    override fun next(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getDouble(index: Double): Double {
        TODO("Not yet implemented")
    }

    override fun getLong(index: Double): Double {
        TODO("Not yet implemented")
    }

    override fun getString(index: Double): String {
        TODO("Not yet implemented")
    }

    override fun getBytes(index: Double): ByteArray {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }
}