package com.fylyheng.composeapp1.news_app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fylyheng.composeapp1.news_app.view_model.BlogPostViewModel

@Composable
fun BlogPostScreen(viewModel: BlogPostViewModel, innerPaddingValues: PaddingValues) {

    val allBlogPost = viewModel.allBlogPost

    Column (modifier = Modifier.fillMaxWidth().padding(innerPaddingValues)){

        BlogPostHeaderComposable()
        Spacer(modifier = Modifier.height(6.dp))
        BlogPostList(allBlogPost)

    }



}