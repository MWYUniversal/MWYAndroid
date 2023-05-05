package com.owner.banner

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.owner.banner.adapter.ExamplePagerAdapter
import com.owner.banner.databinding.ActivityIndicatorBinding
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator.OnCircleClickListener
import java.util.*


class IndicatorActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityIndicatorBinding

    private val CHANNELS = arrayOf(
        "CUPCAKE",
        "DONUT",
        "ECLAIR",
        "GINGERBREAD",
        "HONEYCOMB",
        "ICE_CREAM_SANDWICH",
        "JELLY_BEAN",
        "KITKAT",
        "LOLLIPOP",
        "M",
        "NOUGAT"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityIndicatorBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        var examplePagerAdapter = ExamplePagerAdapter(CHANNELS.toMutableList())
        mBinding.viewPager.adapter = examplePagerAdapter

        initMagicIndicator()
    }

    private fun initMagicIndicator() {



        val circleNavigator = CircleNavigator(this)
        circleNavigator.circleCount = CHANNELS.size
        circleNavigator.circleColor = Color.RED
        circleNavigator.circleClickListener =
            OnCircleClickListener { index -> mBinding.viewPager.currentItem = index }
        mBinding.indicator.navigator = circleNavigator

        ViewPagerHelper.bind(mBinding.indicator, mBinding.viewPager)
    }
}