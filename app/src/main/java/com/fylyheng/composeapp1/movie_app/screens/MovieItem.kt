package com.fylyheng.composeapp1.movie_app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fylyheng.composeapp1.movie_app.retofit.movie.Movie
import kotlin.random.Random

@Composable
fun MovieItem (movie: Movie) {

    Card (
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(200.dp),

        colors = CardDefaults.cardColors(containerColor = getRandomColor()),
    ){

        Row (modifier = Modifier.padding(8.dp)){

            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp)),
                model = "https://image.tmdb.org/t/p/w500/${movie.posterPath}",
                contentDescription = "Movie Image"
            )

            Spacer(modifier = Modifier.height(18.dp))

            Column (modifier = Modifier.padding(16.dp)){
                Text(text = movie.title, style = MaterialTheme.typography.labelLarge)
                Text(text = movie.overview, style = MaterialTheme.typography.bodySmall)
            }
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


