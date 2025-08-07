package com.fylyheng.composeapp1.news_app.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.fylyheng.composeapp1.news_app.retrofit.blogPost.BlogPost

@Composable
fun BlogPostList (posts: List<BlogPost>) {

    LazyColumn {
        items(posts) {
            BlogPostItem(it)
        }
    }

}