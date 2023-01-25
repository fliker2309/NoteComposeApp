package com.example.notecleanapp.domain.usecases

import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.domain.repository.NoteRepository
import javax.inject.Inject

interface GetNoteByIdUseCase {

    suspend fun getNoteById(id: Long): Note?

    class Base @Inject constructor(private val repository: NoteRepository) : GetNoteByIdUseCase {

        override suspend fun getNoteById(id: Long): Note? {
            return repository.getNoteById(id)
        }
    }
}
