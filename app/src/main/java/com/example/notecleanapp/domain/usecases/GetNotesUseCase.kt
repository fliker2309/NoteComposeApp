package com.example.notecleanapp.domain.usecases

import com.example.notecleanapp.domain.repository.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val repository: NoteRepository) {
    suspend operator fun invoke() = repository.getAllNotes()
}
