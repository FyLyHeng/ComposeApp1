package com.fylyheng.composeapp1.news_app.retrofit

import com.fylyheng.composeapp1.news_app.retrofit.blogPost.BlogPost
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getAllBlogPost() : List<BlogPost>

}