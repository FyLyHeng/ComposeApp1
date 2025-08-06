package com.fylyheng.composeapp1.note_app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.fylyheng.composeapp1.note_app.room_db.note.Note
import com.fylyheng.composeapp1.note_app.view_model.NoteViewModel

@Composable
fun DisplayDialog(viewModel: NoteViewModel, showDialog: Boolean, onDismiss : () -> Unit) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedColor by remember { mutableStateOf(Color.Blue) }


    if (showDialog) {
        AlertDialog(
            modifier = Modifier,
            title = {Text("Enter Note")},
            text = {
                Column {
                    TextField(
                        label = {Text("Note Title")},
                        value = title,
                        onValueChange = { title=it }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        label = {Text("Note Description")},
                        value = description,
                        onValueChange = { description=it }
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }
            },

            onDismissRequest = {},

            confirmButton = {

                Button(onClick = {
                    val note = Note(
                        title = title,
                        description = description,
                        color = selectedColor.toArgb()
                    )
                    viewModel.insertNewNote(note)
                    onDismiss()

                }) {
                    Text(text = "Save Note")
                }
            },

            dismissButton = {
                Button(onClick = onDismiss) { Text(text = "Cancel") }
            },
        )
    }
}