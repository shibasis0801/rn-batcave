package com.myntra.appscore.core

import android.app.Activity
import android.view.KeyEvent
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.lang.ref.WeakReference

abstract class Adapter(activity: BaseActivity): DefaultLifecycleObserver {
    // Todo Unsafe
    constructor(activity: Activity) : this(activity as BaseActivity)

    val ref = WeakReference(activity)
    val activity
        get() = ref.get()!!

    // Todo Unsafe
    operator fun<T> invoke(function: BaseActivity.() -> T) = ref.get()!!.run(function)


    override fun onCreate(owner: LifecycleOwner) { invoke { onCreate(this) } }
    override fun onStart(owner: LifecycleOwner) { invoke { onStart(this) } }
    override fun onResume(owner: LifecycleOwner) { invoke { onResume(this) } }
    override fun onPause(owner: LifecycleOwner) { invoke { onPause(this) } }
    override fun onStop(owner: LifecycleOwner) { invoke { onStop(this) } }
    override fun onDestroy(owner: LifecycleOwner) { invoke { onDestroy(this) } }

    open fun onCreate(activity: BaseActivity) {}
    open fun onStart(activity: BaseActivity) {}
    open fun onResume(activity: BaseActivity) {}
    open fun onPause(activity: BaseActivity) {}
    open fun onStop(activity: BaseActivity) {}
    open fun onDestroy(activity: BaseActivity) {}

    // New Observers
    open fun onBackPressed(activity: BaseActivity) {}
    // Order matters
    open fun onKeyUp(activity: BaseActivity, keyCode: Int, event: KeyEvent?): Boolean = false
}
