package com.fylyheng.composeapp1.note_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable
fun NoteColorPicker(selectedColor: Color, onSelected : (Color)-> Unit) {

    val colorList = listOf(
        Color("#8ecae6".toColorInt()), // light blue
        Color("#ffb703".toColorInt()), // bright yellow-orange
        Color("#219ebc".toColorInt()),// teal blue
        Color("#023047".toColorInt()), // deep navy
        Color("#fb8500".toColorInt()), // vivid orange
        Color("#a3b18a".toColorInt()), // sage green
        Color("#ff006e".toColorInt()), // hot pink
        Color("#8338ec".toColorInt()) // vibrant purple

    )

    LazyRow (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(colorList) {
            NoteColorPick(selectedColor, onSelected, it)
        }
    }
}




@Composable
fun NoteColorPick(selectedColor: Color, onColorSelected: (Color)-> Unit, color: Color) {

    Box (modifier = Modifier
        .size(40.dp)
        .padding(4.dp)
        .clip(CircleShape)
        .background(color = color)
        .border(
            width = if (color == selectedColor) 4.dp else 0.dp,
            color = if (color == selectedColor) Color.Black else Color.Transparent,
            shape = CircleShape
        )
        .clickable { onColorSelected(color) }
    ) {

    }
}