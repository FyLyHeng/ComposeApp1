package com.fylyheng.composeapp1.movie_app.data.retofit

import com.fylyheng.composeapp1.movie_app.data.movie.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey : String) : BaseResponse
}