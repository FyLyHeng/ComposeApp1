package com.fylyheng.composeapp1.room_db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fylyheng.composeapp1.room_db.note.Note

@Dao
interface AppDao {

    @Insert
    suspend fun insertNewNote(note: Note)

    @Query("select * from note")
    fun getAllNotes() : LiveData<List<Note>>
}