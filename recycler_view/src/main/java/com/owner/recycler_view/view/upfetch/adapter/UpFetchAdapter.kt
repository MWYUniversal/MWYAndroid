package com.owner.recycler_view.view.upfetch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.owner.recycler_view.R
import com.owner.recycler_view.databinding.ItemHeaderAndFooterBinding
import com.owner.recycler_view.entity.Movie

/**
 * @date: 2019-12-06
 * @Description:
 */
class UpFetchAdapter : BaseQuickAdapter<Movie?, UpFetchAdapter.VH>() {
    class VH(
        parent: ViewGroup,
        val viewBinding: ItemHeaderAndFooterBinding = ItemHeaderAndFooterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    ) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): VH {
        return VH(parent)
    }

    override fun onBindViewHolder(holder: VH, position: Int, item: Movie?) {
        when (holder.layoutPosition % 3) {
            0 -> holder.viewBinding.iv.setImageResource(R.mipmap.animation_img1)
            1 -> holder.viewBinding.iv.setImageResource(R.mipmap.animation_img2)
            2 -> holder.viewBinding.iv.setImageResource(R.mipmap.animation_img3)
            else -> {}
        }
    }
}