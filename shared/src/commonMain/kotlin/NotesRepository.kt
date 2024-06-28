import app.cash.sqldelight.coroutines.asFlow
import comlanshanginstructionmanual.Note
import comlanshanginstructionmanual.NoteQueries
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

class NotesRepository(
    private val noteQueries: NoteQueries
): KoinComponent {

    fun watchNotes(): Flow<List<Note>> {
        return noteQueries.findAll().asFlow().map { noteQuery ->
            withContext(Dispatchers.IO) {
                noteQuery.executeAsList()
            }
        }
    }

    suspend fun insertNote(content: String) {
        withContext(Dispatchers.IO) {
            noteQueries.insert(
                id = null,
                content = content,
                date_created = kotlinx.datetime.Clock.System.now()
            )
        }
    }
}