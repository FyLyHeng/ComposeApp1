package com.fylyheng.composeapp1.news_app.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fylyheng.composeapp1.news_app.retrofit.blogPost.BlogPost
import com.fylyheng.composeapp1.news_app.retrofit.blogPost.BlogPostRepository
import kotlinx.coroutines.launch

class BlogPostViewModel : ViewModel() {

    private val blogPostRepository = BlogPostRepository()

    //init state
    var allBlogPost by mutableStateOf<List<BlogPost>>(emptyList())
        private set


    init {
        viewModelScope.launch {

            //fetching data from api
            val fachBlogPost = blogPostRepository.getPosts()

            //update result to state
            allBlogPost = fachBlogPost

        }
    }
}