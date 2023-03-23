package com.owner.recycler_view.view.headerfooter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.owner.recycler_view.R
import com.owner.recycler_view.databinding.ItemHeaderAndFooterBinding
import com.owner.recycler_view.entity.Status


/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
class HeaderAndFooterAdapter(list: List<Status>) :
    BaseQuickAdapter<Status?, HeaderAndFooterAdapter.VH>(list) {

    class VH(var binding: ItemHeaderAndFooterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): VH {
        val binding =
            ItemHeaderAndFooterBinding.inflate(LayoutInflater.from(context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int, item: Status?) {
        when (holder.layoutPosition % 3) {
            0 -> holder.binding.iv.setImageResource(R.mipmap.animation_img1)
            1 -> holder.binding.iv.setImageResource(R.mipmap.animation_img2)
            2 -> holder.binding.iv.setImageResource(R.mipmap.animation_img3)
            else -> {}
        }
    }
}