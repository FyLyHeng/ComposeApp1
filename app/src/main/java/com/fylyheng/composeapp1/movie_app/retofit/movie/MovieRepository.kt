package com.fylyheng.composeapp1.movie_app.retofit.movie

import com.fylyheng.composeapp1.movie_app.retofit.RetrofitClient

class MovieRepository {

    suspend fun getPopularMovieFromApi() : List<Movie> {

        return RetrofitClient.api.getPopularMovies("92bb5e15800d198dade6db765a0dd263").results

    }
}