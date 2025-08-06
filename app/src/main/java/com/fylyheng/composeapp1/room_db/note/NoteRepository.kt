package com.fylyheng.composeapp1.room_db.note

import androidx.lifecycle.LiveData

interface NoteRepository {

    suspend fun insert(note: Note)
    suspend fun getAll() : LiveData<List<Note>>
}