package com.owner.recycler_view.view.dragswipe.adapter

import android.content.Context
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseDifferAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import com.owner.recycler_view.R
import com.owner.recycler_view.entity.DiffEntity
import com.owner.recycler_view.view.differ.adapter.DiffEntityCallback


/**
 * Create adapter
 */
class DiffDragAndSwipeAdapter :
    BaseDifferAdapter<DiffEntity, QuickViewHolder>(DiffEntityCallback()) {

    override fun onCreateViewHolder(
        context: Context, parent: ViewGroup, viewType: Int
    ): QuickViewHolder {
        return QuickViewHolder(R.layout.layout_animation, parent)
    }

    override fun onBindViewHolder(
        holder: QuickViewHolder, position: Int, item: DiffEntity?
    ) {
        holder.setText(R.id.tweetName, item!!.title)
            .setText(R.id.tweetText, item.content)
            .setText(R.id.tweetDate, item.date)
    }
}