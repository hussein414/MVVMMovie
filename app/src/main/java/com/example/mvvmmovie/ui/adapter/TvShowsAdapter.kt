package com.example.mvvmmovie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.mvvmmovie.data.model.TvShowsItem
import com.example.mvvmmovie.databinding.ItemCardBinding

class TvShowsAdapter() : Adapter<TvShowsViewHolder>() {
    private val diffCallBack = object : DiffUtil.ItemCallback<TvShowsItem>() {
        override fun areItemsTheSame(oldItem: TvShowsItem, newItem: TvShowsItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TvShowsItem, newItem: TvShowsItem): Boolean =
            oldItem == newItem
    }
    private val differ = AsyncListDiffer(this, diffCallBack)
    var tvShowsModel: List<TvShowsItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder =
        TvShowsViewHolder(
              ItemCardBinding.inflate(
                  LayoutInflater.from(parent.context),
                  parent,
                  false
              )
          )

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        holder.bindViews(tvShowsModel[position])
    }

    override fun getItemCount(): Int = tvShowsModel.size
}