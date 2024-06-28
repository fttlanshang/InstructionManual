import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun NavigationDestination(
    content: @Composable () -> Unit
) {

    val destinationId: String = rememberSaveable { generateUUID() }

    // This is actually only relevant for Android
    DisposeNavigationDestinationEffect()

    CompositionLocalProvider(LocalDestinationId provides destinationId) {
        content()
    }
}