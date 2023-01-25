package com.example.notecleanapp.data.local.database

import androidx.room.Database
import com.example.notecleanapp.data.local.dao.NoteDao
import com.example.notecleanapp.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase {
    abstract fun noteDao(): NoteDao
}
