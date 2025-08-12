package com.fylyheng.composeapp1.movie_app.data.retofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val api : ApiService by lazy {

        Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

}