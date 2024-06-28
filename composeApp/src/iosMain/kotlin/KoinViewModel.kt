import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.rickclephas.kmp.observableviewmodel.ViewModel
import org.koin.compose.koinInject

@Composable
actual inline fun <reified T : ViewModel> koinViewModel(): T {

    val viewModel: T = koinInject()

    DisposableEffect(Unit) {
        onDispose {
            viewModel.onCleared()
        }
    }

    return viewModel
}