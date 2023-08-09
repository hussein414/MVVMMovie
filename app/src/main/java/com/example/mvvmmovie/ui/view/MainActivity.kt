package com.example.mvvmmovie.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvmmovie.databinding.ActivityMainBinding
import com.example.mvvmmovie.ui.adapter.TvShowsAdapter
import com.example.mvvmmovie.ui.viewmodel.TvShowsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TvShowsViewModel by viewModels()
    private lateinit var showsAdapter: TvShowsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindViews()
    }

    private fun bindViews() {
        showsAdapter = TvShowsAdapter()
        viewModel.responseTvShows.observe(this) { response ->
            showsAdapter.tvShowsModel = response
        }
        binding.recyclerView.apply {
            adapter = showsAdapter
            layoutManager =
                GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }
}