package com.fylyheng.composeapp1.news_app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fylyheng.composeapp1.news_app.retrofit.blogPost.BlogPost
import kotlin.random.Random


@Composable
fun BlogPostItem(blogPost: BlogPost) {

    Card (
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        colors = CardDefaults.cardColors(containerColor = getRandomColor()),
    ){
        Column (modifier = Modifier.padding(16.dp)){
            Text(text = blogPost.title, style = MaterialTheme.typography.labelLarge)
            Text(text = blogPost.body, style = MaterialTheme.typography.bodySmall)
        }
    }

}

fun getRandomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
}