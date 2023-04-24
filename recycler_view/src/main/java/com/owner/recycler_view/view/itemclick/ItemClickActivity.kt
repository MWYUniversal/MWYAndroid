package com.owner.recycler_view.view.itemclick

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.owner.recycler_view.R
import com.owner.recycler_view.base.BaseViewBindingActivity
import com.owner.recycler_view.databinding.ActivityUniversalRecyclerBinding
import com.owner.recycler_view.entity.ClickEntity
import com.owner.recycler_view.utils.Tips
import com.owner.recycler_view.view.itemclick.adapter.ItemClickAdapter


class ItemClickActivity : BaseViewBindingActivity<ActivityUniversalRecyclerBinding>() {

    private val adapter: ItemClickAdapter by lazy(LazyThreadSafetyMode.NONE) {
        // 创建数据
        val data = ArrayList<ClickEntity>().apply {
            add(ClickEntity(ClickEntity.CLICK_ITEM_VIEW))
            add(ClickEntity(ClickEntity.CLICK_ITEM_CHILD_VIEW))
            add(ClickEntity(ClickEntity.LONG_CLICK_ITEM_VIEW))
            add(ClickEntity(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW))
        }
        // 创建Adapter
        ItemClickAdapter(data)
    }

    override fun initBinding(): ActivityUniversalRecyclerBinding =
        ActivityUniversalRecyclerBinding.inflate(layoutInflater)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.titleBar.title = "Item Click Use"
        viewBinding.titleBar.setOnBackListener { finish() }
        viewBinding.rv.layoutManager = LinearLayoutManager(this)
        viewBinding.rv.adapter = adapter

        // 设置点击事件
        adapter.setOnItemClickListener { _, _, position ->
            Tips.show("onItemClick $position")
        }

        // 设置item 长按事件
        adapter.setOnItemLongClickListener { _, _, position ->
            Tips.show("onItemLongClick $position")
            true
        }

        // 添加子 view 的点击事件
        adapter.addOnItemChildClickListener(R.id.btn) { adapter, view, position ->
            Tips.show("onItemChildClick: $position")
        }
        adapter.addOnItemChildClickListener(R.id.iv_num_reduce) { adapter, view, position ->
            Tips.show("onItemChildClick:  reduce $position")
        }
        adapter.addOnItemChildClickListener(R.id.iv_num_add) { adapter, view, position ->
            Tips.show("onItemChildClick:  add $position")
        }

        // 设置子 view 长按事件
        adapter.addOnItemChildLongClickListener(R.id.btn_long) { adapter, view, position ->
            Tips.show("onItemChildLongClick $position")
            true
        }
    }

}