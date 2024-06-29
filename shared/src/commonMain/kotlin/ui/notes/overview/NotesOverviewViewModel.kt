package notes.overview

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.coroutineScope
import comlanshanginstructionmanual.Note
import domain.usecases.WatchNotesUseCase
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class NotesOverviewViewModel(
    watchNotesUseCase: WatchNotesUseCase
): ViewModel() {
    val notes: StateFlow<ImmutableList<Note>> = watchNotesUseCase.call()
        .map(List<Note>::toImmutableList)
        .stateIn(
            viewModelScope.coroutineScope,
            // Starts collecting data from the upstream Flow only when there are active subscribers.
            //Stops collecting data after a 5-second delay when there are no more subscribers.
            SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000L),
            persistentListOf() // initial value for the stateFlow
        )

}