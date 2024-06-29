package domain.usecases

import NotesRepository

class CreateNoteUseCase(
    private val notesRepository: NotesRepository
) {
    suspend fun call(content: String) {
        notesRepository.insertNote(content)
    }
}