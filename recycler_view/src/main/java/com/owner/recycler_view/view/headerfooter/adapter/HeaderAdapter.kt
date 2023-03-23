package com.owner.recycler_view.view.headerfooter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseSingleItemAdapter
import com.owner.recycler_view.R


class HeaderAdapter : BaseSingleItemAdapter<Any, HeaderAdapter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.head_view, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, item: Any?) {

    }
}