package com.example.notecleanapp.data.local.dao

import androidx.room.*
import com.example.notecleanapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAllNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note
}
