package com.example.notecleanapp.presentation.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.domain.usecases.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel(), AddNote {
    override fun addNote(note: Note, onSuccess: () -> Unit) {
        viewModelScope.launch {
            addNoteUseCase.invoke(note)
            onSuccess()
        }
    }
}

interface AddNote {
    fun addNote(note: Note, onSuccess: () -> Unit)
}
