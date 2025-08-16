package com.fylyheng.composeapp1.quiz_app.presentation.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fylyheng.composeapp1.quiz_app.presentation.dashboard.component.UserStatisticsCard
import com.fylyheng.composeapp1.quiz_app.presentation.dashboard.component.UserStatisticsHeaderCard
import com.fylyheng.composeapp1.ui.quiz_app_theme.QuizAppTheme

@Composable
fun DashboardScreen (innerPaddingValues: PaddingValues, state: DashboardState) {

    Column (modifier = Modifier.padding(innerPaddingValues)) {

        UserStatisticsHeaderCard(userName = state.username, userRateLevel =  state.userLevel, totalScore =  state.userScore)

        Spacer(modifier = Modifier.size(16.dp))

        UserStatisticsCard(totalQuiz = state.questionAttempted, totalCorrectAnswers = state.correctAnswers)

    }

}


@Preview(showBackground = true)
@Composable
fun DashboardScreensPreview() {
    QuizAppTheme {
        DashboardScreen(PaddingValues(16.dp), DashboardState())
    }
}


fun testElvis() {

    //v1
    val name: String? = null
    val displayName1 : String = name?: "Guest" // If 'name' is null, 'displayName' becomes "Guest"
    print(displayName1) //Guest


    //v2
    val nickName : String? = null
    val display2 = if (nickName != null) nickName else "Guest"
    print(display2) //Guest

    val displayName2 : String = name?: throw Exception("name can not be null")

    //v3
    val firstName : String? = null
    var display3 : String
    if (firstName != null) {
        display3 = firstName
    }
    else {
        display3 = "Guest"
        print("")
        throw Exception()
        testSafeCall()
    }

    print(display3) //Guest
}


fun testSafeCall() {

    // count s1 when s1 != null
    val s1 : String? = "my name is heng"
    val s2CountDigit = s1?.count() // call function

    if (s1!=null) {
        val s2CountDigit = s1.count()
    }

    print(s2CountDigit)


    var name: String = "heng"
    var nameCountDigit = name.last()
    println(nameCountDigit) // null

}