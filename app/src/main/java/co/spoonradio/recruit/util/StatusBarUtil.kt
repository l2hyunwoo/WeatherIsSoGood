package co.spoonradio.recruit.util

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.view.View

object StatusBarUtil {
    @SuppressLint("InlinedApi")
    @Suppress("DEPRECATION")
    fun setStatusBar(activity: Activity, color: Int, lightBar: Boolean) {
        if (!lightBar) {
            activity.window?.decorView?.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        activity.window?.statusBarColor = color
    }
}