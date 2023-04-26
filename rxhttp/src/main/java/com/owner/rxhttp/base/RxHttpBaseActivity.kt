package com.owner.rxhttp.base

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.owner.rxhttp.R
import com.owner.rxhttp.util.statusBarLightMode

abstract class RxHttpBaseActivity(@LayoutRes layoutRes: Int = 0): AppCompatActivity(layoutRes) {

    protected open val contentView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        contentView?.let {
            setContentView(it)
        }

        if (Build.VERSION.SDK_INT >= 21) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.spinner_bg)
            window.statusBarLightMode = false
        }
    }

}