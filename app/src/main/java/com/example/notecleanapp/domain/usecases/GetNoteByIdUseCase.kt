package com.example.notecleanapp.domain.usecases

import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.domain.repository.NoteRepository
import javax.inject.Inject

class GetNoteByIdUseCase @Inject constructor(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}
