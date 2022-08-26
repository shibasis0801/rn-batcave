package com.myntra.appscore.androidApp

import android.app.Activity
import android.view.KeyEvent
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.lang.ref.WeakReference

abstract class Adapter(activity: Activity): DefaultLifecycleObserver {
    private val ref = WeakReference(activity)

    operator fun<T> invoke(function: Activity.() -> T) = ref.get()?.run(function)

    fun onMainThread(insideBaseFn:  Activity.() -> Unit) = ref.get()?.apply {
        runOnUiThread { insideBaseFn() }
    }

    override fun onCreate(owner: LifecycleOwner) { invoke { onCreate(this) } }
    override fun onStart(owner: LifecycleOwner) { invoke { onStart(this) } }
    override fun onResume(owner: LifecycleOwner) { invoke { onResume(this) } }
    override fun onPause(owner: LifecycleOwner) { invoke { onPause(this) } }
    override fun onStop(owner: LifecycleOwner) { invoke { onStop(this) } }
    override fun onDestroy(owner: LifecycleOwner) { invoke { onDestroy(this) } }

    open fun onCreate(activity: Activity) {}
    open fun onStart(activity: Activity) {}
    open fun onResume(activity: Activity) {}
    open fun onPause(activity: Activity) {}
    open fun onStop(activity: Activity) {}
    open fun onDestroy(activity: Activity) {}

    // New Observers
    open fun onBackPressed(activity: Activity) {}
    // Order matters
    open fun onKeyUp(activity: Activity, keyCode: Int, event: KeyEvent?): Boolean = false
}