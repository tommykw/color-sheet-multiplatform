package color.sheet.common

import androidx.compose.ui.graphics.Color as ComposeColor

actual val Colors.BLACK: Color
    get() = Color(0,0,0)

actual val Colors.WHITE: Color
    get() = Color(255, 255, 255)

fun getTextColor(red: Int, green: Int, blue: Int): ComposeColor {
    return if (getFontColor(red, green, blue) == Colors.BLACK) {
        ComposeColor.Black
    } else {
        ComposeColor.White
    }
}