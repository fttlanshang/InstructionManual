package ui.platform

import android.app.Activity
import android.view.Window
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat

@Composable
actual fun BackHandler(onBackPressed: () -> Unit) {
    androidx.activity.compose.BackHandler(
        enabled = true,
        onBack = onBackPressed
    )
}

@Composable
actual fun StatusBarColor(
    color: androidx.compose.ui.graphics.Color,
    lightStatusBar: Boolean
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window: Window = (view.context as Activity).window
            window.statusBarColor = color.toArgb()
            WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = lightStatusBar
        }
    }
}