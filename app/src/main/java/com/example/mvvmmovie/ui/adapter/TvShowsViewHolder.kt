package com.example.mvvmmovie.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.mvvmmovie.data.model.TvShowsItem
import com.example.mvvmmovie.databinding.ItemCardBinding

class TvShowsViewHolder(private val binding: ItemCardBinding) : ViewHolder(binding.root) {
    fun bindViews(model: TvShowsItem) {
        binding.apply {
            image.load(model.image.original) {
                crossfade(true)
                crossfade(1000)
            }
            name.text = model.name
        }
    }
}