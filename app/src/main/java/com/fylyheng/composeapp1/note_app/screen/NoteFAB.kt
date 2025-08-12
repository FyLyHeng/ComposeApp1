package com.fylyheng.composeapp1.note_app.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.fylyheng.composeapp1.note_app.view_model.NoteViewModel

@Composable
fun NoteFAB(viewModel: NoteViewModel) {

    var showDialog by remember { mutableStateOf(false) }

    DisplayDialog(viewModel, showDialog) {
        showDialog = false
    }

    FloatingActionButton(
        onClick = { showDialog = true },
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Note"
        )
    }
}