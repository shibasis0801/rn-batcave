package com.myntra.appscore.batcave

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.view.KeyEvent
import com.facebook.react.BuildConfig
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactPackage
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.soloader.SoLoader
import com.myntra.appscore.core.Adapter
import kotlin.random.Random

// Needs improvements
class ReactAdapter(
    activity: Activity
): Adapter(activity), DefaultHardwareBackBtnHandler {

    private val code = Random.nextInt(100, 200)

    var rootView: ReactRootView? = null
    var instanceManager: ReactInstanceManager? = null

    fun requestPermission(activity: Activity) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M) {
            if(!Settings.canDrawOverlays(activity)) {
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package: ${activity.packageName}")
                )
                activity.startActivityForResult(intent, code);
            }
        }
    }

    fun onPermissionResult(activity: Activity, requestCode: Int, resultCode: Int, data: Intent?) {
        instanceManager?.onActivityResult(activity, requestCode, resultCode, data)
    }

    fun startReact(packageList: List<ReactPackage> = listOf()) = invoke {
        SoLoader.init(this, false)
        rootView = ReactRootView(this)
//        val packages: List<ReactPackage> = PackageList(activity.application).packages

        // Packages that cannot be autolinked yet can be added manually here, for example:
        // packages.add(MyReactNativePackage())
        // Remember to include them in `settings.gradle` and `app/build.gradle` too.
        instanceManager = ReactInstanceManager.builder()
            .setApplication(application)
            .setCurrentActivity(this)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("index")
            .addPackages(packageList)
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()
        // The string here (e.g. "MyReactNativeApp") has to match
        // the string in AppRegistry.registerComponent() in index.js
        rootView?.startReactApplication(instanceManager, "MyReactNativeApp", null)
        requestPermission(this)
    }

    override fun onResume(activity: Activity) {
        instanceManager?.onHostResume(activity, this)
    }

    override fun onStop(activity: Activity) {
        super.onStop(activity)
    }

    override fun onPause(activity: Activity) {
        instanceManager?.onHostPause(activity)
        rootView?.unmountReactApplication()
    }

    override fun onDestroy(activity: Activity) {
        instanceManager?.onHostDestroy(activity)
    }

    override fun onBackPressed(activity: Activity) {
        instanceManager?.onBackPressed()
    }

    override fun invokeDefaultOnBackPressed() {
        invoke { onBackPressed() }
    }

    override fun onKeyUp(activity: Activity, keyCode: Int, event: KeyEvent?) = run {
        if (keyCode == KeyEvent.KEYCODE_MENU && instanceManager != null) {
            instanceManager?.showDevOptionsDialog()
            true
        } else false
    }
}
