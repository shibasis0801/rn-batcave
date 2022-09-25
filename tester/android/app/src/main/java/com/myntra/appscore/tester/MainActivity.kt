package com.myntra.appscore.tester;

import android.os.Bundle;
import com.facebook.react.ReactActivity;
import com.myntra.appscore.batcave.NativeAdapter

class MainActivity: ReactActivity() {

  override fun getMainComponentName() = "BatTester"
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val cppAdapter = NativeAdapter()
  }
}
