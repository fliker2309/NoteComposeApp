package com.example.notecleanapp.domain.repository

import com.example.notecleanapp.domain.model.Note

interface NoteRepository {
    suspend fun getAllNotes(): List<Note>
    suspend fun getNoteById(id: Int): Note?
    suspend fun addNote(note: Note)
    suspend fun deleteNote(note: Note)
}
