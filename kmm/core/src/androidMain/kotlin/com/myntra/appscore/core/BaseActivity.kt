package com.myntra.appscore.core

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import org.koin.core.context.startKoin
import java.lang.ref.WeakReference

abstract class BaseActivity: AppCompatActivity() {
    // You must initialize this
    var observers: List<DefaultLifecycleObserver> = listOf()

    // Run it once ? Have two instances of one adapter ?
    val adapters: List<Adapter>
        get() = observers.map { if (it is Adapter) it else null }.filterNotNull()

    fun connectLifecycle(vararg observers: DefaultLifecycleObserver) {
        this.observers = observers.toList()
        this.observers.forEach(lifecycle::addObserver)
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
    first to handle and return true will prevent other observers from running
    */
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        adapters.forEach {
            val result = it.onKeyUp(this, keyCode, event)
            if (result) return true
        }
        return super.onKeyUp(keyCode, event)
    }
}
