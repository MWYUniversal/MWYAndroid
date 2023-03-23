package com.owner.recycler_view.view.animation

import android.os.Bundle
import com.chad.library.adapter.base.BaseQuickAdapter
import com.owner.recycler_view.animator.CustomAnimation1
import com.owner.recycler_view.animator.CustomAnimation2
import com.owner.recycler_view.animator.CustomAnimation3
import com.owner.recycler_view.base.BaseViewBindingActivity
import com.owner.recycler_view.databinding.ActivityAnimationUseBinding

import com.owner.recycler_view.view.animation.adapter.AnimationAdapter

class AnimationUseActivity : BaseViewBindingActivity<ActivityAnimationUseBinding>() {

    private val mAnimationAdapter: AnimationAdapter = AnimationAdapter().apply {
        // 打开 Adapter 的动画
        animationEnable = true
        // 是否是首次显示时候加载动画
        isAnimationFirstOnly = false
    }

    override fun initBinding(): ActivityAnimationUseBinding {
        return ActivityAnimationUseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.titleBar.title = "Animation Use"
        viewBinding.titleBar.setOnBackListener { finish() }

        viewBinding.rv.adapter = mAnimationAdapter

        initMenu()
    }

    /**
     * Init menu
     * 初始化下拉菜单
     */
    private fun initMenu() {
        viewBinding.spinner.setItems(
            "AlphaIn",
            "ScaleIn",
            "SlideInBottom",
            "SlideInLeft",
            "SlideInRight",
            "Custom1",
            "Custom2",
            "Custom3"
        )
        viewBinding.spinner.setOnItemSelectedListener { _, position, _, _ ->
            when (position) {
                0 -> mAnimationAdapter.setItemAnimation(BaseQuickAdapter.AnimationType.AlphaIn)
                1 -> mAnimationAdapter.setItemAnimation(BaseQuickAdapter.AnimationType.ScaleIn)
                2 -> mAnimationAdapter.setItemAnimation(BaseQuickAdapter.AnimationType.SlideInBottom)
                3 -> mAnimationAdapter.setItemAnimation(BaseQuickAdapter.AnimationType.SlideInLeft)
                4 -> mAnimationAdapter.setItemAnimation(BaseQuickAdapter.AnimationType.SlideInRight)
                5 -> mAnimationAdapter.itemAnimation = CustomAnimation1()
                6 -> mAnimationAdapter.itemAnimation = CustomAnimation2()
                7 -> mAnimationAdapter.itemAnimation = CustomAnimation3()
                else -> {}
            }
            mAnimationAdapter.notifyDataSetChanged()

        }

        //init firstOnly state
        viewBinding.switchButton.setOnCheckedChangeListener { _, isChecked ->
            mAnimationAdapter.isAnimationFirstOnly = isChecked
            mAnimationAdapter.notifyDataSetChanged()
        }
    }
}