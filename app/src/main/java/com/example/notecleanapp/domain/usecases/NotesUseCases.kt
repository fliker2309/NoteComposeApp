package com.example.notecleanapp.domain.usecases

data class NotesUseCases(
    val deleteNote: DeleteNoteUseCase,
    val addNote: AddNoteUseCase,
    val getNoteById: GetNoteByIdUseCase,
    val getAllNotes: GetNotesUseCase
)
