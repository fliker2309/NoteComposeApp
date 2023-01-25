package com.example.notecleanapp.domain.usecases

import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetNotesUseCase {
    fun getNotes(): Flow<List<Note>>
    class Base @Inject constructor(private val repository: NoteRepository) : GetNotesUseCase {
        override fun getNotes(): Flow<List<Note>> {
            return repository.getAllNotes()
        }
    }
}
