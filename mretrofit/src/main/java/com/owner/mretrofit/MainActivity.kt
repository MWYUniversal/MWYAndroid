package com.owner.mretrofit

import android.os.Bundle
import com.owner.mretrofit.base.BaseViewBindingActivity
import com.owner.mretrofit.databinding.ActivityMainBinding

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>() {

    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.retro.setOnClickListener {

        }
    }
}