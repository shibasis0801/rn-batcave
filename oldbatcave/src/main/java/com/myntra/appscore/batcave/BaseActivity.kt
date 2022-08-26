package com.myntra.appscore.androidApp

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    // You must initialize this
    var adapters: List<Adapter> = listOf()
    fun connectLifecycle(vararg adapters: Adapter) {
        this.adapters = adapters.toList()
        this.adapters.forEach(lifecycle::addObserver)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        adapters.forEach {
            it.onBackPressed(this)
        }
    }

    /*
    Create a KeyHandleDelegate & Interface and forward all key events there
    God observers are also not good.
    Ordering of Observers matters here,
    first to handle and return true will prevent other adapters from running
     */
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        adapters.forEach {
            val result = it.onKeyUp(this, keyCode, event)
            if (result) return true
        }
        return super.onKeyUp(keyCode, event)
    }
}