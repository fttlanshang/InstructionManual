package data.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.lanshang.instruction.manual.Database

actual object DriverFactory {
    actual fun createDriver(databaseName: String): SqlDriver {
        return NativeSqliteDriver(Database.Schema, databaseName)
    }
}