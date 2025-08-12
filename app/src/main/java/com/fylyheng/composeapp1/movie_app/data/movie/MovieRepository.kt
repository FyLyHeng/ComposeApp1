package com.fylyheng.composeapp1.movie_app.data.movie

import android.content.Context
import com.fylyheng.composeapp1.movie_app.data.retofit.RetrofitClient
import com.fylyheng.composeapp1.movie_app.data.room_db.AppDatabase
import com.fylyheng.composeapp1.movie_app.data.room_db.MovieDAO

class MovieRepository(context: Context) {

    suspend fun getPopularMovieFromApi() : List<Movie> {

        return RetrofitClient.api.getPopularMovies("92bb5e15800d198dade6db765a0dd263").results

    }


    val appDb = AppDatabase.getInstance(context)
    val movieDao : MovieDAO = appDb.appDao

    suspend fun getAllMovieFromDB(): List<Movie> {
        return movieDao.getAllMovieFromDB()
    }

    suspend fun insertMovieIntoDB(movie: Movie) {
        movieDao.insertMovie(movie)
    }

    suspend fun insertMovieIntoDB(movie: List<Movie>) {
        movieDao.insertMovieList(movie)
    }
}