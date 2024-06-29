package domain.usecases

import NotesRepository
import comlanshanginstructionmanual.Note
import kotlinx.coroutines.flow.Flow

class WatchNotesUseCase(
    private val notesRepository: NotesRepository
) {
    fun call(): Flow<List<Note>> {
        return notesRepository.watchNotes()
    }
}