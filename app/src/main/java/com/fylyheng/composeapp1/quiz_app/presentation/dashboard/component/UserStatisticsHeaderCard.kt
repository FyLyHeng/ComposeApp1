package com.fylyheng.composeapp1.quiz_app.presentation.dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fylyheng.composeapp1.R
import com.fylyheng.composeapp1.ui.quiz_app_theme.QuizAppTheme


@Composable
fun UserStatisticsHeaderCard(modifier: Modifier = Modifier, userName: String, userRateLevel: String, totalScore: Int) {


    Row  (
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        UserAvatar(modifier = Modifier, userName, userRateLevel,R.drawable.avator_24)
        UserScore(totalScore)
    }

}


@Composable
fun UserAvatar(modifier: Modifier, userName: String,userRateLevel:String, iconRes: Int) {

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Box (
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .size(40.dp)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ){
            Icon(
                modifier = Modifier,
                painter = painterResource(iconRes),
                contentDescription = userName
            )


        }
        Spacer(modifier = Modifier.size(6.dp))
        Column {
            Text(text = userName, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))

            Box(modifier = Modifier
                .clip(MaterialTheme.shapes.extraLarge)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f))
            ) {
                Text(text = "   $userRateLevel   ", style = MaterialTheme.typography.titleSmall)
            }
        }
    }

}


@Composable
fun UserScore(totalScore: Int) {

    Box (modifier = Modifier
        .clip(MaterialTheme.shapes.extraLarge)
        .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f))
        .padding(2.5.dp)

        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box (
                    modifier = Modifier
                        .size(40.dp)
                        .clip(MaterialTheme.shapes.extraLarge)
                        .background(MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center
                ){
                    Icon(painter = painterResource(R.drawable.outline_stars_24),
                        contentDescription = "score",
                        tint = MaterialTheme.colorScheme.error
                    )
                }

                Spacer(modifier = Modifier.size(6.dp))

                Text(
                    text = "$totalScore  ",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Normal)
                )
            }
    }




}


@Preview(showBackground = false)
@Composable
fun UserHeaderPreview() {
    QuizAppTheme {
        UserStatisticsHeaderCard(modifier = Modifier, userName = "Fylyheng Phally", "Expert",1200)
    }
}