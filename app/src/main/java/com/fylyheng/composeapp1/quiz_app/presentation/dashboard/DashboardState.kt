package com.fylyheng.composeapp1.quiz_app.presentation.dashboard

data class DashboardState (

    val username : String = "Phally Fylyheng",
    val userLevel: String = "Expert",
    val userScore : Int = 1200,
    val questionAttempted : Int = 20,
    val correctAnswers : Int = 15
)