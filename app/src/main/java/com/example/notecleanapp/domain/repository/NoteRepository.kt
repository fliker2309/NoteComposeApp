package com.example.notecleanapp.domain.repository

import com.example.notecleanapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Long): Note?
    suspend fun addNote(note: Note)
    suspend fun deleteNote(note: Note)
}
