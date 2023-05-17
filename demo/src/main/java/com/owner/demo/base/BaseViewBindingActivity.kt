package com.owner.demo.base

import android.view.View
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingActivity<V : ViewBinding> : BaseActivity() {

    private var _viewBinding: V? = null

    protected val mBinding: V
        get() {
            return _viewBinding ?: throw IllegalStateException(
                "Should be called initBinding()"
            )
        }

    /**
     * 初始化 [mBinding]
     */
    abstract fun initBinding(): V

    final override val contentView: View
        get() {
            return initBinding().apply {
                _viewBinding = this
            }.root
        }

}