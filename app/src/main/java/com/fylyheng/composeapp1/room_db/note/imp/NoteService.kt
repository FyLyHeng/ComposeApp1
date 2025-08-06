package com.fylyheng.composeapp1.room_db.note.imp

import androidx.lifecycle.LiveData
import com.fylyheng.composeapp1.room_db.AppDao
import com.fylyheng.composeapp1.room_db.note.Note
import com.fylyheng.composeapp1.room_db.note.NoteRepository

class NoteService (
    private val appDao: AppDao

) : NoteRepository {

    override suspend fun insert(note: Note) {
        return appDao.insertNewNote(note)
    }


    override suspend fun getAll(): LiveData<List<Note>> {
        return appDao.getAllNotes()
    }
}