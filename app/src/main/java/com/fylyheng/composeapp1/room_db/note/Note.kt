package com.fylyheng.composeapp1.room_db.note

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val title : String,
    val description : String,

    @ColumnInfo(name = "note_color_background")
    val color : String
)