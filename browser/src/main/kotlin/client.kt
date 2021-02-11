import color.sheet.common.baseColors
import color.sheet.common.getTextColor
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.p
import kotlinx.html.span
import kotlinx.html.style
import org.w3c.dom.Node

fun main() {
    window.onload = { document.body?.appendContents() }
}

fun Node.appendContents() {

    append {
        p {
            +"Color Sheet"
        }

        div {
            baseColors.forEach { r ->
                baseColors.forEach { g ->
                    baseColors.forEach { b ->
                        span {
                            +"#${r}${g}${b}"

                            val textColor = getTextColor(r.toInt(16), g.toInt(16), b.toInt(16))
                            style = "display: inline-block; width: 80px; margin: 0.5rem; padding: 1rem 2rem; text-align: center; background-color: #${r}${g}${b}; color: $textColor"
                        }
                    }
                }
            }
        }
    }
}