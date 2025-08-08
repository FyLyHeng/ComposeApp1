package com.fylyheng.composeapp1.note_app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylyheng.composeapp1.note_app.room_db.note.Note

@Composable
fun NoteItem (note: Note) {

    Card(
        elevation = CardDefaults.elevatedCardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(note.color)),
    ) {

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(text = note.title, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal, fontSize = 18.sp)

            Spacer(modifier = Modifier.height(6.dp))

            Text(text = note.description, fontWeight = FontWeight.Thin, fontStyle = FontStyle.Normal, fontSize = 16.sp)
        }
    }
}