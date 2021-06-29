package com.app.moviekuapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.moviekuapp.data.model.GoToGenre
import com.app.moviekuapp.data.model.GoToVideo
import com.app.moviekuapp.data.model.entity.Genre
import com.app.moviekuapp.data.model.entity.Video
import com.app.moviekuapp.databinding.ListItemGenreBinding
import com.app.moviekuapp.databinding.ListItemVideoBinding

class GenreListAdapter internal constructor(private val goToGenre: GoToGenre) :
    ListAdapter<(Genre), GenreListAdapter.ViewHolder>(GenreDiffCallback()) {

    class ViewHolder(private val binding: ListItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(goToGenre: GoToGenre, item: Genre) {
            binding.goToInterface = goToGenre
            binding.genre = item
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(goToGenre, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemGenreBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    private class GenreDiffCallback : DiffUtil.ItemCallback<Genre>() {
        override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean {
            return oldItem.id == newItem.id
        }
    }
}