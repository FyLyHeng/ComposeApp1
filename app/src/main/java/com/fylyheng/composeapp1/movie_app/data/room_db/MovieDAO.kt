package com.fylyheng.composeapp1.movie_app.data.room_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fylyheng.composeapp1.movie_app.data.movie.Movie

@Dao
interface MovieDAO {

    @Insert
    suspend fun insertMovie(movie: Movie)

    @Insert
    suspend fun insertMovieList(movie: List<Movie>)

    @Query("select * from movie")
    suspend fun getAllMovieFromDB() : List<Movie>
}