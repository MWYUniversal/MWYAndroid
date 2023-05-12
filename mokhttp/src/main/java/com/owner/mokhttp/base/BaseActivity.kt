package com.owner.mokhttp.base

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.owner.mokhttp.R

abstract class BaseActivity(@LayoutRes layoutRes: Int = 0) : AppCompatActivity(layoutRes) {

    protected open val contentView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onHandleBar()

        contentView?.let {
            setContentView(it)
        }

    }

    private fun onHandleBar() {
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        // 隐藏状态栏
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        );
        //调用hide()方法将标题栏隐藏起来
        supportActionBar?.hide()

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        WindowCompat.getInsetsController(window, window.decorView)!!.isAppearanceLightStatusBars =
            false
    }
}