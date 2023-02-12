package com.example.notecleanapp.presentation.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.domain.usecases.DeleteNoteUseCase
import com.example.notecleanapp.domain.usecases.GetNoteByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel(), GetNote, DeleteNote {

    private val _note = MutableLiveData<Note>()
    val note: LiveData<Note>
        get() = _note

    override fun getNoteById(id: Int) {
        viewModelScope.launch {
            getNoteByIdUseCase.invoke(id = id).let {
                _note.postValue(it)
            }
        }
    }

    override fun deleteNote(onSuccess: () -> Unit) {
        viewModelScope.launch {
            note.value?.let {
                deleteNoteUseCase.invoke(note = it)
                onSuccess()
            }
        }
    }
}

interface GetNote {
    fun getNoteById(id: Int)
}

interface DeleteNote {
    fun deleteNote(onSuccess: () -> Unit)
}
