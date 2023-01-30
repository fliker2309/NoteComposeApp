package com.example.notecleanapp.data.local.repository

import com.example.notecleanapp.data.local.dao.NoteDao
import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val dao: NoteDao) : NoteRepository {
    override fun getAllNotes(): List<Note> {
        return dao.getAllNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun addNote(note: Note) {
        dao.addNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}
