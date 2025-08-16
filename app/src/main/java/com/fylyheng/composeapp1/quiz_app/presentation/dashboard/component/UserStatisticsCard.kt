package com.fylyheng.composeapp1.quiz_app.presentation.dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fylyheng.composeapp1.R
import com.fylyheng.composeapp1.ui.quiz_app_theme.CustomBlue
import com.fylyheng.composeapp1.ui.quiz_app_theme.CustomPink
import com.fylyheng.composeapp1.ui.quiz_app_theme.QuizAppTheme

@Composable
fun UserStatisticsCard(modifier: Modifier= Modifier, totalQuiz: Int, totalCorrectAnswers: Int) {

    val processBar = calCorrectPercentage(totalQuiz, totalCorrectAnswers)

    Card (
        modifier = modifier.padding(10.dp),
        elevation = CardDefaults.elevatedCardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
    ){

        ProgressBar(
            modifier = Modifier.fillMaxWidth().padding(10.dp).height(15.dp),
            gradientColors = listOf(CustomBlue,CustomPink),
            barProgress = processBar
        )

        Row (modifier =
            Modifier.fillMaxWidth().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ){
            UseStatistics(totalQuiz,"Questions Attempted", R.drawable.outline_touch_app_24)
            UseStatistics(totalCorrectAnswers,"Correct Answers", R.drawable.baseline_check_circle_24)
        }
    }





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


@Composable
fun UseStatistics(value: Int, description:String, iconRes:Int) {

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Box (
            modifier = Modifier
                .size(45.dp)
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ){
            Icon(painter = painterResource(iconRes),
                contentDescription = description,
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        Spacer(modifier = Modifier.size(6.dp))
        Column {
            Text(text = "$value", style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold))
            Text(text = description, style = MaterialTheme.typography.labelSmall)
        }
    }

}



@Preview(showBackground = false)
@Composable
fun UserStatisticsPreview() {
    QuizAppTheme {
        UserStatisticsCard(modifier = Modifier, totalQuiz = 20, totalCorrectAnswers = 17)
    }
}


private fun calCorrectPercentage(allQuiz: Int, correctAnswers: Int) : Float {

    if (allQuiz <= 0) {
        return 0f
    }

    return correctAnswers.toFloat() / allQuiz
}