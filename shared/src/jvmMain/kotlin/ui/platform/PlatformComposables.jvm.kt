package ui.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
actual fun BackHandler(onBackPressed: () -> Unit) {
}

@Composable
actual fun StatusBarColor(
    color: Color,
    lightStatusBar: Boolean
) {
}