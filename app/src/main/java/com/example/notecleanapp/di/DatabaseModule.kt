package com.example.notecleanapp.di

import android.app.Application
import androidx.room.Room
import com.example.notecleanapp.data.local.database.NoteDatabase
import com.example.notecleanapp.data.local.repository.NoteRepositoryImpl
import com.example.notecleanapp.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            "NoteDatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao())
    }

// TODO  подумать как пробросить зависимости
}
