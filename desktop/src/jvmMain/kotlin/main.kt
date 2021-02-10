import androidx.compose.desktop.Window
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import color.sheet.common.BLACK
import color.sheet.common.Colors
import color.sheet.common.baseColors
import color.sheet.common.getFontColor

fun main() = Window(
    title = "Color Sheet",
    size = IntSize(width = 500, height = 600)
) {

    Box(
        modifier = Modifier.fillMaxSize()
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {

        ScrollableColumn(
            modifier = Modifier.fillMaxSize(),
        ) {

            baseColors.forEach { r ->
                baseColors.forEach { g ->
                    baseColors.forEach { b ->
                        TextBox(
                            text = "#$r$g$b",
                            backgroundColor = Color(r.toInt(16), g.toInt(16), b.toInt(16)),
                            textColor = getTextColor(r.toInt(16), g.toInt(16), b.toInt(16))
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun TextBox(
    text: String,
    backgroundColor: Color,
    textColor: Color,
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .height(32.dp)
            .background(color = backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = textColor)
    }
}

fun getTextColor(red: Int, green: Int, blue: Int): Color {
    return if (getFontColor(red, green, blue) == Colors.BLACK) {
        Color.Black
    } else {
        Color.White
    }
}