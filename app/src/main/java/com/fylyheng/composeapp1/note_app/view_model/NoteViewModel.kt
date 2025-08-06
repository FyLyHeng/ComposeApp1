package com.fylyheng.composeapp1.note_app.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fylyheng.composeapp1.note_app.room_db.note.Note
import com.fylyheng.composeapp1.note_app.room_db.note.imp.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel (private val noteRepo : NoteRepository) : ViewModel() {

    fun allNotes() : LiveData<List<Note>> {
        return noteRepo.getAll()
    }


    // launch: is a coroutine builder that launch new thread
    // coroutine without blocking the current thread
    // noteRepo.insert(note) is a suspend fun so we need to use with launch
    fun insertNewNote(note: Note) = viewModelScope.launch {
        noteRepo.insert(note)
    }


}