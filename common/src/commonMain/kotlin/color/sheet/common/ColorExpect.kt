package color.sheet.common

import kotlin.math.pow

data class Color(
    val r: Int,
    val g: Int,
    val b: Int,
)

object Colors
expect val Colors.BLACK : Color
expect val Colors.WHITE : Color

val baseColors = listOf("00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "AA", "BB", "CC", "DD", "EE", "FF")

fun getRGBForCalculateLuminance(_color: Int): Double {
    val color = _color / 255
    return if (color <= 0.03928) {
        color / 12.92
    } else {
        ((color + 0.055) / 1.055).pow(2.4)
    }
}

fun getRelativeLuminance(color: Color): Double {
    val (red, green, blue) = color
    val r = getRGBForCalculateLuminance(red)
    val g = getRGBForCalculateLuminance(green)
    val b = getRGBForCalculateLuminance(blue)
    return 0.2126 * r + 0.7152 * g + 0.0722 * b
}

fun getContrastRatio(color1: Color, color2: Color): Double {
    val luminance1 = getRelativeLuminance(color1)
    val luminance2 = getRelativeLuminance(color2)
    val bright = maxOf(luminance1, luminance2)
    val dark = minOf(luminance1, luminance2)
    return (bright + 0.05) / (dark + 0.05)
}

fun getFontColor(red: Int, green: Int, blue: Int): Color {
    val color = Color(red, green, blue)
    val whiteRatio = getContrastRatio(color, Colors.WHITE)
    val blackRatio = getContrastRatio(color, Colors.BLACK)
    return if (whiteRatio > blackRatio) Colors.WHITE else Colors.BLACK
}