package com.fylyheng.composeapp1.old_data.classes

interface FavoriteRepository {

    suspend fun getFavorites() : Result<List<String>>

    suspend fun toggleFavorite(id:String) : Result<List<String>>
}


data class Favorite(
    val id: String
)