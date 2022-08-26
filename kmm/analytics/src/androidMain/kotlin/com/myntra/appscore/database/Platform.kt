package com.myntra.appscore.database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}
