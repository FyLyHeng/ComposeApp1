package com.fylyheng.composeapp1.quiz_app.presentation.dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fylyheng.composeapp1.ui.quiz_app_theme.CustomBlue
import com.fylyheng.composeapp1.ui.quiz_app_theme.CustomPink

@Composable
fun UserStatisticsCard(modifier: Modifier, totalQuiz: Int, totalCorrectAnswers: Int) {

    val processBar = calCorrectPercentage(totalQuiz, totalCorrectAnswers)

    ProgressBar(
        modifier = Modifier.fillMaxWidth().height(15.dp),
        gradientColors = listOf(CustomBlue,CustomPink),
        barProgress = processBar
    )

}


@Composable
fun ProgressBar(modifier: Modifier, gradientColors: List<Color> = listOf(CustomPink,CustomPink), barProgress: Float = 1f) {

    Box (modifier = modifier
        .clip(MaterialTheme.shapes.extraSmall)
        .background(MaterialTheme.colorScheme.background)
    ) {

        Box(modifier = Modifier
            .clip(MaterialTheme.shapes.extraSmall)
            .fillMaxWidth(barProgress)
            .fillMaxHeight()
            .background(Brush.linearGradient(gradientColors))
        )

        Box(modifier = Modifier
            .padding(end = 5.dp)
            .align(Alignment.CenterEnd)
            .size(5.dp)
            .clip(CircleShape)
            .background(Brush.linearGradient(gradientColors))
        )

    }
}

private fun calCorrectPercentage(allQuiz: Int, correctAnswers: Int) : Float {

    if (allQuiz <= 0) {
        return 0f
    }

    return correctAnswers.toFloat() / allQuiz
}