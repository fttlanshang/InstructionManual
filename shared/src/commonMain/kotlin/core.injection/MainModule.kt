package core.injection

import NotesRepository
import com.lanshang.instruction.manual.Database
import data.db.DriverFactory
import data.db.createDatabase
import domain.usecases.CreateNoteUseCase
import domain.usecases.WatchNotesUseCase
import notes.create.CreateNoteViewModel
import notes.overview.NotesOverviewViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ui.navigation.Navigator

val mainModule = module {
    // Here we can later provide our injectable objects
    single { createDatabase(DriverFactory.createDriver("notes.db")) }
    single { get<Database>().noteQueries }
    singleOf(::NotesRepository)
    factoryOf(::CreateNoteViewModel)
    factoryOf(::NotesOverviewViewModel)
    singleOf(::WatchNotesUseCase)
    singleOf(::CreateNoteUseCase)
    singleOf(::Navigator)
}