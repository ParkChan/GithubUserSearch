package com.githubsearcher.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.githubsearcher.base.BaseRecyclerView
import com.githubsearcher.data.Users

@Suppress("UNCHECKED_CAST")
@BindingAdapter("replaceItems")
fun RecyclerView.replaceItems(items: List<Users>?) {
    (this.adapter as? BaseRecyclerView.Adapter<Any, *>)?.run {
        replaceItems(items)
        notifyDataSetChanged()
    }
}