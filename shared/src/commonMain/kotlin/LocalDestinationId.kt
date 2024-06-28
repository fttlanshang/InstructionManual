import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

val LocalDestinationId: ProvidableCompositionLocal<String> = staticCompositionLocalOf {
    generateUUID()
}