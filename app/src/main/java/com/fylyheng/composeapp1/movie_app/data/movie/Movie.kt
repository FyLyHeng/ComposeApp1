package com.fylyheng.composeapp1.movie_app.data.movie

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class BaseResponse(

    val page: Int,
    val results : List<Movie>,

    @SerializedName("total_pages")
    val totalPages : Int,

    @SerializedName("total_results")
    val totalResults : Int

)

@Entity("movie")
data class Movie(

    @PrimaryKey
    val id: Int,

    val isAdult: Boolean,
    val overview: String,

    val title: String,
    val isVideo: Boolean,
    val popularity: Double,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("original_language")
    val originalLanguage: String,

    @SerializedName("original_title")
    val originalTitle: String,


    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Int
)
