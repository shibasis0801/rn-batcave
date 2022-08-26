package com.myntra.appscore.tester;

import android.os.Bundle;
import android.util.Log
import com.facebook.react.ReactActivity;
import com.myntra.appscore.batcave.CppAdapter

class MainActivity: ReactActivity() {

  override fun getMainComponentName() = "BatTester"
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val cppAdapter = CppAdapter()
    Log.d("SHIBASIS", cppAdapter.stringFromJNI())
  }


}
