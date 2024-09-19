package com.edgetoedge

import android.graphics.Color
import android.graphics.Color.parseColor
import android.os.Build
import androidx.core.view.WindowInsetsControllerCompat
import com.facebook.common.logging.FLog
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.UiThreadUtil
import com.facebook.react.common.ReactConstants


class EdgeToEdgeModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  @ReactMethod
  fun setStatusBarStyle(
    style: String
  ) {
    if (currentActivity == null) {
      FLog.w(
        ReactConstants.TAG,
        "Ignored status bar change, current activity is null."
      )
      return
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//SDK >= 24

      val window = currentActivity!!.window
      val decorView = window.decorView

      val isDarkMode = "dark-content" == style

      UiThreadUtil.runOnUiThread {
        WindowInsetsControllerCompat(
          window,
          decorView
        ).isAppearanceLightStatusBars = isDarkMode
      }

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {//SDK >= 27
        UiThreadUtil.runOnUiThread {
          WindowInsetsControllerCompat(
            window,
            decorView
          ).isAppearanceLightNavigationBars = "dark-content" == style
        }
      }
    }
  }

  @ReactMethod
  fun setNavigationBarBackgroundColor(colorHex: String?) {
    if (currentActivity == null) {
      FLog.w(
        ReactConstants.TAG,
        "Ignored status bar change, current activity is null."
      )
      return
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      UiThreadUtil.runOnUiThread {
        currentActivity!!.window.navigationBarColor = if(colorHex != null) parseColor(colorHex) else Color.TRANSPARENT
      }
    }
  }

  companion object {
    const val NAME = "EdgeToEdge"
  }
}
