package data.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.lanshang.instruction.manual.Database

actual object DriverFactory {
    actual fun createDriver(databaseName: String): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver(url ="jdbc:sqlite:notes.db")
        Database.Schema.create(driver)
        return driver
    }
}