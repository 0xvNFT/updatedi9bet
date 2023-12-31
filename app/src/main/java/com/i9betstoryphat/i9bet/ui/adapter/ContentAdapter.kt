package com.i9betstoryphat.i9bet.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.i9betstoryphat.i9bet.R
import com.i9betstoryphat.i9bet.base.BaseMainAdapter
import com.i9betstoryphat.i9bet.base.BaseRecyclerViewViewHolder
import com.i9betstoryphat.i9bet.data.Content
import com.i9betstoryphat.i9bet.databinding.ItemContentHomeBinding

class ContentAdapter : BaseMainAdapter<Content>() {

    var click:((Content) -> Unit)? = null
    override fun onCreateHolder(view: ViewGroup): BaseRecyclerViewViewHolder<Content> {
        return Item(ItemContentHomeBinding.inflate(LayoutInflater.from(view.context), view, false)).apply {
            itemView.setOnClickListener {
                val item = mList[adapterPosition]
                click?.invoke(item)
            }
            itemView.findViewById<ImageView>(R.id.image).setOnClickListener {
                val item = mList[adapterPosition]
                click?.invoke(item)
            }
        }
    }

    class Item(val binding: ItemContentHomeBinding) :
        BaseRecyclerViewViewHolder<Content>(binding.root) {

        override fun bind(item: Content) {
            item.path?.let { binding.image.setImageResource(it) }
            binding.textTitle.text = item.title
            binding.textDetail.text = item.detail
        }
    }
}
