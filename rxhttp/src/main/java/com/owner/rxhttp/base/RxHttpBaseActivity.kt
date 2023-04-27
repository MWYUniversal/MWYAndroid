package com.owner.rxhttp.base

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.owner.rxhttp.R
import com.owner.rxhttp.util.statusBarLightMode

abstract class RxHttpBaseActivity(@LayoutRes layoutRes: Int = 0) : AppCompatActivity(layoutRes) {

    protected open val contentView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        // 隐藏状态栏
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        );
        //调用hide()方法将标题栏隐藏起来
        supportActionBar?.hide()



        contentView?.let {
            setContentView(it)
        }

        if (Build.VERSION.SDK_INT >= 21) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.spinner_bg)
            window.statusBarLightMode = false
        }
    }

}