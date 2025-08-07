package com.fylyheng.composeapp1.news_app.retrofit.blogPost

import com.fylyheng.composeapp1.news_app.retrofit.RetrofitClient


class BlogPostRepository {

    private val repo = RetrofitClient.api

    suspend fun getPosts(): List<BlogPost> {
        return repo.getAllBlogPost()
    }


}
