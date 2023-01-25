package com.example.notecleanapp.domain.usecases

import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.domain.repository.NoteRepository
import javax.inject.Inject

interface DeleteNoteUseCase {
    suspend fun deleteNote(note: Note)
    class Base @Inject constructor(private val repository: NoteRepository) : DeleteNoteUseCase {
        override suspend fun deleteNote(note: Note) {
            repository.deleteNote(note)
        }
    }
}
