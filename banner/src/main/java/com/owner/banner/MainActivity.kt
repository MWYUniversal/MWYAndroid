package com.owner.banner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.owner.banner.databinding.ActivityMainBinding
import com.youth.banner.Banner

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        mBinding.textBanner.setOnClickListener {
            startActivity(Intent(this,BannerActivity::class.java))
        }

        mBinding.textIndicator.setOnClickListener {
            startActivity(Intent(this,IndicatorActivity::class.java))
        }
    }
}