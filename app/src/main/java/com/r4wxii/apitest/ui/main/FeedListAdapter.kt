package com.r4wxii.apitest.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.r4wxii.apitest.databinding.CellFeedBinding
import com.r4wxii.apitest.model.Feed

class FeedListAdapter(private val onClickListener: (String) -> Unit) :
    ListAdapter<Feed, FeedListAdapter.ViewHolder>(Feed.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CellFeedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feed = getItem(position)
        holder.binding.feed = feed
        holder.binding.root.setOnClickListener { onClickListener(feed.id) }
    }

    inner class ViewHolder(val binding: CellFeedBinding) : RecyclerView.ViewHolder(binding.root)
}

val Feed.Companion.diffUtil: DiffUtil.ItemCallback<Feed>
    get() = object : DiffUtil.ItemCallback<Feed>() {
        override fun areItemsTheSame(oldItem: Feed, newItem: Feed): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Feed, newItem: Feed): Boolean =
            oldItem.id == newItem.id
    }