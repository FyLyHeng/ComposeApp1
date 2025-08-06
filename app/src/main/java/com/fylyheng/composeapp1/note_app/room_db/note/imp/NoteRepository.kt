package com.fylyheng.composeapp1.note_app.room_db.note.imp

import androidx.lifecycle.LiveData
import com.fylyheng.composeapp1.note_app.room_db.AppDao
import com.fylyheng.composeapp1.note_app.room_db.note.Note

class NoteRepository (
    private val appDao: AppDao

)  {

    suspend fun insert(note: Note) {
        return appDao.insertNewNote(note)
    }


    fun getAll(): LiveData<List<Note>> {
        return appDao.getAllNotes()
    }
}