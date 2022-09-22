package com.myntra.appscore.location

import kotlinx.browser.window

class Location: ILocation {
    override fun hello(): String = "jsMain"

    fun location() {
        window.navigator
    }
}
