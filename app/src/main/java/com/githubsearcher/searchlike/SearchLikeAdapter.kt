package com.githubsearcher.searchlike

import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.githubsearcher.R
import com.githubsearcher.base.BaseRecyclerView
import com.githubsearcher.data.Users
import com.githubsearcher.databinding.RvUserItemBinding

class SearchLikeAdapter(
    private val vm: SearchLikeViewModel,
    private val tabPos: Int
) : BaseRecyclerView.Adapter<Users, RvUserItemBinding>(
    layoutRes,
    bindingVariableId
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerView.ViewHolder<RvUserItemBinding> = ViewHolder(parent)

    inner class ViewHolder(
        parent: ViewGroup
    ) : BaseRecyclerView.ViewHolder<RvUserItemBinding>(
        layoutRes,
        parent,
        bindingVariableId
    ) {

        init {
            binding.vm = vm
            binding.cbStar.isChecked =
                tabPos == 1
        }

        override fun onBindViewHolder(item: Any?) {
            super.onBindViewHolder(item)
            setCheckBoxListener(item as Users)
        }

        private fun setCheckBoxListener(users: Users) {
            with(binding.cbStar) {
                setOnCheckedChangeListener(null)
                isChecked = users.isLike
                setOnCheckedChangeListener { _, isChecked ->
                    users.isLike = isChecked
                }
            }
        }
    }

    companion object {
        private const val layoutRes = R.layout.rv_user_item
        private const val bindingVariableId = BR.users
    }
}