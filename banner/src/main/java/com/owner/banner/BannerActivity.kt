package com.owner.banner

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.owner.banner.adapter.ImageAdapter
import com.owner.banner.adapter.MultipleTypesAdapter
import com.owner.banner.bean.DataBean
import com.owner.banner.databinding.ActivityBannerBinding
import com.youth.banner.indicator.CircleIndicator

class BannerActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityBannerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityBannerBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

//        var imageAdapter = ImageAdapter(DataBean.getTestData2())
        var imageAdapter = MultipleTypesAdapter(this,DataBean.getTestData())


        mBinding.banner.setAdapter(imageAdapter)
            .addBannerLifecycleObserver(this)
            .setIndicator(CircleIndicator(this))
            .setOnBannerListener { data, position -> TODO("Not yet implemented") }

    }
}