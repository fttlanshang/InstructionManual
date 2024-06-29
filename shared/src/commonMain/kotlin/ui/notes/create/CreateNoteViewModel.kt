package notes.create

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.coroutineScope
import domain.usecases.CreateNoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class CreateNoteState(
    val noteText: String = "",
    val onNoteCreated: Boolean = false
)

class CreateNoteViewModel(
    private val createNoteUseCase: CreateNoteUseCase
): ViewModel() {
    private val _state = MutableStateFlow(CreateNoteState())
    val state: StateFlow<CreateNoteState> = _state.asStateFlow()

    fun onNoteTextUpdated(text: String) {
        _state.update { currentState -> currentState.copy(noteText = text) }
    }

    fun createNote() {
        viewModelScope.coroutineScope.launch {
            val noteText = _state.value.noteText

            if (noteText.isNotBlank()) {
                createNoteUseCase.call(noteText)
                _state.update { currentState ->
                    currentState.copy(onNoteCreated = true)
                }
            }

        }
    }

    fun onNoteCreatedConsumed() {
        _state.update { currentState -> currentState.copy(onNoteCreated = false) }
    }

    override fun onCleared() {
        _state.value = CreateNoteState()
        super.onCleared()
    }
}