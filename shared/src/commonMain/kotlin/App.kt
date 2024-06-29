
import androidx.compose.runtime.Composable
import core.injection.mainModule
import org.koin.compose.KoinApplication
import ui.navigation.NavigationHost
import ui.theme.AppTheme

@Composable
fun App() {
    KoinApplication(application = {
        modules(mainModule)
    }) {
        // The default composable content
        AppTheme {
            NavigationHost()
        }
    }
}