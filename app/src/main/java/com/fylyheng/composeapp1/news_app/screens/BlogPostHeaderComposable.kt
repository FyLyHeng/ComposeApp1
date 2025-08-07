package com.fylyheng.composeapp1.news_app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BlogPostHeaderComposable () {

    Column ( modifier =
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(text = "The News App", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Text(text = "Get thr latest Blog Posts & News every sec", fontSize = 16.sp, fontWeight = FontWeight.Normal)
    }


}