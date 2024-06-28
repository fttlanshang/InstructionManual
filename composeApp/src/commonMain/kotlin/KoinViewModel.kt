import androidx.compose.runtime.Composable
import com.rickclephas.kmp.observableviewmodel.ViewModel

@Composable
expect inline fun <reified T : ViewModel> koinViewModel(): T