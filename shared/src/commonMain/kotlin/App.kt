import androidx.compose.runtime.Composable
import org.koin.compose.KoinApplication
import core.injection.mainModule

@Composable
fun App() {
    KoinApplication(application = {
        modules(mainModule)
    }) {
        // The default composable content
    }
}