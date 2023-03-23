package com.owner.recycler_view.view.emptyview

import android.os.Bundle
import android.view.View
import com.owner.recycler_view.view.emptyview.adapter.EmptyViewAdapter
import com.owner.recycler_view.R
import com.owner.recycler_view.base.BaseViewBindingActivity
import com.owner.recycler_view.data.DataServer
import com.owner.recycler_view.databinding.ActivityEmptyViewUseBinding

class EmptyViewUseActivity : BaseViewBindingActivity<ActivityEmptyViewUseBinding>() {

    private val mAdapter = EmptyViewAdapter()

    private var mError = true
    private var mNoData = true

    override fun initBinding(): ActivityEmptyViewUseBinding =
        ActivityEmptyViewUseBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.titleBar.title = "EmptyView Use"
        viewBinding.titleBar.setOnBackListener { finish() }

        viewBinding.btnReset.setOnClickListener { reset() }

        viewBinding.rvList.adapter = mAdapter

        // 打开空布局功能
        mAdapter.isEmptyViewEnable = true
    }

    override fun onStart() {
        super.onStart()
        onRefresh()
    }

    private fun reset() {
        mError = true
        mNoData = true
        mAdapter.submitList(null)
        onRefresh()
    }

    private val emptyDataView: View
        get() {
            val notDataView = layoutInflater.inflate(R.layout.empty_view, viewBinding.rvList, false)
            notDataView.setOnClickListener { onRefresh() }
            return notDataView
        }

    private val errorView: View
        get() {
            val errorView = layoutInflater.inflate(R.layout.error_view, viewBinding.rvList, false)
            errorView.setOnClickListener { onRefresh() }
            return errorView
        }

    private fun onRefresh() {
        // 方式一：直接传入 layout id
        mAdapter.setEmptyViewLayout(this, R.layout.loading_view)

        viewBinding.rvList.postDelayed({
            if (mError) {
                // 方式二：传入View
                mAdapter.emptyView = errorView

                mError = false
            } else {
                if (mNoData) {
                    mAdapter.emptyView = emptyDataView
                    mNoData = false
                } else {
                    mAdapter.submitList(DataServer.getSampleData(10))
                }
            }
        }, 1000)
    }
}