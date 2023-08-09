package com.example.mvvmmovie.data.repository

import com.example.mvvmmovie.data.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class TvShowsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getTvShows() = apiService.getTvShows()
}