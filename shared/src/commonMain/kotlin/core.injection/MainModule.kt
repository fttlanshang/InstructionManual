package core.injection

import com.lanshang.instruction.manual.Database
import data.db.DriverFactory
import data.db.createDatabase
import org.koin.dsl.module

val mainModule = module {
    // Here we can later provide our injectable objects
    single { createDatabase(DriverFactory.createDriver("notes.db")) }
    single { get<Database>().noteQueries }
}