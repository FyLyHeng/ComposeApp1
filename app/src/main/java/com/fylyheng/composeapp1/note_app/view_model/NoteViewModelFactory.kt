package com.fylyheng.composeapp1.note_app.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fylyheng.composeapp1.note_app.room_db.note.imp.NoteRepository

class NoteViewModelFactory (private val noteRepository: NoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(noteRepository) as T
        }
        throw IllegalArgumentException("Unknow View Model Class")

    }

}