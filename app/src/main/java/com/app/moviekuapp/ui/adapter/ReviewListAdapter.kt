package com.app.moviekuapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.moviekuapp.data.model.GoToReview
import com.app.moviekuapp.data.model.entity.Review
import com.app.moviekuapp.databinding.ListItemReviewBinding

class ReviewListAdapter internal constructor(private val goToReview: GoToReview) :
    ListAdapter<(Review), ReviewListAdapter.ViewHolder>(ReviewDiffCallback()) {

    class ViewHolder(private val binding: ListItemReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(goToReview: GoToReview, item: Review) {
            binding.goToInterface = goToReview
            binding.review = item
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(goToReview, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemReviewBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    private class ReviewDiffCallback : DiffUtil.ItemCallback<Review>() {
        override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem.id == newItem.id
        }
    }
}