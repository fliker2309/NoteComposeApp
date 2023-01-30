package com.example.notecleanapp.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.domain.usecases.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase
) : ViewModel(), AllNotes {
    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>>
        get() = _notes

    override fun getAllNotes() {
        viewModelScope.launch {
            getNotesUseCase.getNotes().let {
                _notes.postValue(it)
            }
        }
    }

    init {
        getAllNotes()
    }
}

interface AllNotes {
    fun getAllNotes()
}
