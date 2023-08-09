package com.example.mvvmmovie.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmmovie.data.model.TvShowsItem
import com.example.mvvmmovie.data.repository.TvShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowsViewModel @Inject constructor(private val repository: TvShowsRepository) :
    ViewModel() {
    private val _response = MutableLiveData<List<TvShowsItem>>()
    val responseTvShows: LiveData<List<TvShowsItem>>
        get() = _response

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("error", "getAll tv shows Error:${response.code()}")
            }
        }
    }
}