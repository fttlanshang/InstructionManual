package data.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.lanshang.instruction.manual.Database
import core.appContext

actual object DriverFactory {
    actual fun createDriver(databaseName: String): SqlDriver {
        return AndroidSqliteDriver(schema = Database.Schema, appContext, databaseName)
    }
}