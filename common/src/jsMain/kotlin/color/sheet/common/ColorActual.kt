package color.sheet.common

actual val Colors.BLACK: Color
    get() = Color(0,0,0)

actual val Colors.WHITE: Color
    get() = Color(255, 255, 255)

fun getTextColor(red: Int, green: Int, blue: Int): String {
    return if (getFontColor(red, green, blue) == Colors.BLACK) {
        "#000000"
    } else {
        "#FFFFFF"
    }
}
