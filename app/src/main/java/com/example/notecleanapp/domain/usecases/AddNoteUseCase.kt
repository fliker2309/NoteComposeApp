package com.example.notecleanapp.domain.usecases

import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.domain.repository.NoteRepository
import javax.inject.Inject

interface AddNoteUseCase {
    suspend fun addNote(note: Note)
    class Base @Inject constructor(private val repository: NoteRepository) : AddNoteUseCase {
        override suspend fun addNote(note: Note) {
            repository.addNote(note)
        }
    }
}
