package com.example.notecleanapp.domain.usecases

import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) = repository.deleteNote(note)
}
