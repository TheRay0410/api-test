package com.r4wxii.apitest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.r4wxii.apitest.databinding.CellEntryBinding
import com.r4wxii.apitest.model.Entry

class EntryListAdapter :  ListAdapter<Entry, EntryListAdapter.ViewHolder>(Entry.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CellEntryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.entry = getItem(position)
    }

    inner class ViewHolder(val binding: CellEntryBinding) : RecyclerView.ViewHolder(binding.root)
}

val Entry.Companion.diffUtil: DiffUtil.ItemCallback<Entry>
    get() = object : DiffUtil.ItemCallback<Entry>() {
        override fun areItemsTheSame(oldItem: Entry, newItem: Entry): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Entry, newItem: Entry): Boolean = oldItem.id == newItem.id
    }