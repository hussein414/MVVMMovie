package com.example.mvvmmovie.data.service

import com.example.mvvmmovie.data.model.TvShowsResponse
import com.example.mvvmmovie.utils.Constance
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constance.END_POINT)
    suspend fun getTvShows():Response<TvShowsResponse>
}