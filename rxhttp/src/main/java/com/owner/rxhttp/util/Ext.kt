package com.owner.rxhttp.util

import android.view.Window
import androidx.core.view.WindowCompat


/**
 * 设置状态栏高亮模式
 */
inline var Window.statusBarLightMode: Boolean
    set(value) {
        WindowCompat.getInsetsController(this, decorView)!!.isAppearanceLightStatusBars = value
    }
    get() {
        return WindowCompat.getInsetsController(this, decorView)!!.isAppearanceLightStatusBars
    }

