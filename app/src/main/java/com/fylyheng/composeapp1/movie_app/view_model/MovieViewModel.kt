package com.fylyheng.composeapp1.movie_app.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.fylyheng.composeapp1.movie_app.data.movie.Movie
import com.fylyheng.composeapp1.movie_app.data.movie.MovieRepository
import kotlinx.coroutines.launch


class MovieViewModel(repository: MovieRepository) : ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var movieFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set

    var movieFromDB by mutableStateOf<List<Movie>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            try {

                //fetch data from api
                movieFromApi = repository.getPopularMovieFromApi()

                //set all fetched movies to db offline
                repository.insertMovieIntoDB(movieFromApi)

                //update state
                movies = movieFromApi

            } catch (e: Exception){

                //get from room
                movieFromDB = repository.getAllMovieFromDB()

                //update movie-ui state
                movies = movieFromDB
            }
        }
    }
}


class MovieViewModelFactory (private val movieRepository: MovieRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(movieRepository) as T
        }
        throw IllegalArgumentException("Unknow View Model Class")

    }

}