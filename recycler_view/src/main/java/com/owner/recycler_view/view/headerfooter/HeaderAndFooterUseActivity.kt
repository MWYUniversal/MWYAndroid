package com.owner.recycler_view.view.headerfooter

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.QuickAdapterHelper
import com.owner.recycler_view.base.BaseViewBindingActivity
import com.owner.recycler_view.data.DataServer
import com.owner.recycler_view.databinding.ActivityUniversalRecyclerBinding
import com.owner.recycler_view.utils.Tips
import com.owner.recycler_view.view.headerfooter.adapter.FooterAdapter
import com.owner.recycler_view.view.headerfooter.adapter.HeaderAdapter
import com.owner.recycler_view.view.headerfooter.adapter.HeaderAndFooterAdapter

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
class HeaderAndFooterUseActivity : BaseViewBindingActivity<ActivityUniversalRecyclerBinding>() {

    private lateinit var helper: QuickAdapterHelper

    override fun initBinding(): ActivityUniversalRecyclerBinding =
        ActivityUniversalRecyclerBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.titleBar.title = "Header And Footer Use"
        viewBinding.titleBar.setOnBackListener { finish() }


        val adapter = HeaderAndFooterAdapter(DataServer.getSampleData(PAGE_SIZE))


        adapter.setOnItemClickListener {  _, _, position ->
            Tips.show("position: $position")
        }


        helper = QuickAdapterHelper.Builder(adapter)
            .build()

        viewBinding.rv.layoutManager = LinearLayoutManager(this)
        viewBinding.rv.adapter = helper.adapter
        addHeader()

        helper.addAfterAdapter(
            FooterAdapter(false).setOnItemClickListener { _, _, _ ->
                addFooter()
            }
        )
    }

    private fun addHeader() {
        helper.addBeforeAdapter(0, HeaderAdapter().apply {
            setOnItemClickListener { _, _, _ ->
                addHeader()
            }
        })
    }

    private fun addFooter() {
        helper.addAfterAdapter(FooterAdapter(true).setOnItemClickListener { adapter, _, _ ->
            helper.removeAdapter(adapter)
        })
    }

    companion object {
        private const val PAGE_SIZE = 3
    }
}