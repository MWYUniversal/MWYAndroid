package com.owner.recycler_view.view.headerfooter.adapter

import android.content.Context
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseSingleItemAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import com.owner.recycler_view.R

class FooterAdapter(
    private val isDelete: Boolean
) : BaseSingleItemAdapter<Any, QuickViewHolder>() {

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): QuickViewHolder {
        return QuickViewHolder(R.layout.footer_view, parent)
    }

    override fun onBindViewHolder(holder: QuickViewHolder, item: Any?) {
        if (isDelete) {
            holder.setImageResource(R.id.iv, R.mipmap.rm_icon)
        }
    }
}