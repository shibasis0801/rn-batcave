package com.myntra.appscore.location

import kotlinx.coroutines.Dispatchers

class Location: ILocation {
    override fun hello(): String = "androidMain"
    fun test() {
        Dispatchers.IO

    }
}
