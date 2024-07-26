import TMAVariables.AccentTextColor
import TMAVariables.AccentTextColorValue
import TMAVariables.BackgroundColor
import TMAVariables.BackgroundColorValue
import TMAVariables.ButtonColor
import TMAVariables.ButtonColorValue
import TMAVariables.ButtonTextColor
import TMAVariables.ButtonTextColorValue
import TMAVariables.DestructiveTextColor
import TMAVariables.DestructiveTextColorValue
import TMAVariables.HeaderBackgroundColor
import TMAVariables.HeaderBackgroundColorValue
import TMAVariables.HintColor
import TMAVariables.HintColorValue
import TMAVariables.LinkColor
import TMAVariables.LinkColorValue
import TMAVariables.SecondaryBackgroundColor
import TMAVariables.SecondaryBackgroundColorValue
import TMAVariables.SectionBackgroundColor
import TMAVariables.SectionBackgroundColorValue
import TMAVariables.SectionHeaderTextColor
import TMAVariables.SectionHeaderTextColorValue
import TMAVariables.SubtitleTextColor
import TMAVariables.SubtitleTextColorValue
import TMAVariables.TextColor
import TMAVariables.TextColorValue
import dev.inmo.tgbotapi.webapps.HEXColor
import dev.inmo.tgbotapi.webapps.ThemeParams
import org.jetbrains.compose.web.css.*

object TMAVariables {
    val BackgroundColorValue = Color("#ffffff")
    val BackgroundColor by variable<CSSColorValue>()
    val SecondaryBackgroundColorValue = Color("#ffffff")
    val SecondaryBackgroundColor by variable<CSSColorValue>()
    val TextColorValue = Color("#000000")
    val TextColor by variable<CSSColorValue>()
    val HintColorValue = Color.gray
    val HintColor by variable<CSSColorValue>()
    val LinkColorValue = Color("#229ED9")
    val LinkColor by variable<CSSColorValue>()
    val ButtonColorValue = Color("#229ED9")
    val ButtonColor by variable<CSSColorValue>()
    val ButtonTextColorValue = Color("#ffffff")
    val ButtonTextColor by variable<CSSColorValue>()
    val HeaderBackgroundColorValue = Color("#ffffff")
    val HeaderBackgroundColor by variable<CSSColorValue>()
    val AccentTextColorValue = Color("#229ED9")
    val AccentTextColor by variable<CSSColorValue>()
    val SectionBackgroundColorValue = Color("#ffffff")
    val SectionBackgroundColor by variable<CSSColorValue>()
    val SectionHeaderTextColorValue = Color("#000000")
    val SectionHeaderTextColor by variable<CSSColorValue>()
    val SubtitleTextColorValue = Color.gray
    val SubtitleTextColor by variable<CSSColorValue>()
    val DestructiveTextColorValue = Color.red
    val DestructiveTextColor by variable<CSSColorValue>()
}

fun StyleScope.applyThemeVariables(theme: ThemeParams) {
    BackgroundColor(theme.backgroundColor?.toCSSColorValue() ?: BackgroundColorValue)
    SecondaryBackgroundColor(theme.secondaryBackgroundColor?.toCSSColorValue() ?: SecondaryBackgroundColorValue)
    TextColor(theme.textColor?.toCSSColorValue() ?: TextColorValue)
    HintColor(theme.hintColor?.toCSSColorValue() ?: HintColorValue)
    LinkColor(theme.linkColor?.toCSSColorValue() ?: LinkColorValue)
    ButtonColor(theme.buttonColor?.toCSSColorValue() ?: ButtonColorValue)
    ButtonTextColor(theme.buttonTextColor?.toCSSColorValue() ?: ButtonTextColorValue)
    HeaderBackgroundColor(theme.headerBgColor?.toCSSColorValue() ?: HeaderBackgroundColorValue)
    AccentTextColor(theme.accentTextColor?.toCSSColorValue() ?: AccentTextColorValue)
    SectionBackgroundColor(theme.sectionBgColor?.toCSSColorValue() ?: SectionBackgroundColorValue)
    SectionHeaderTextColor(theme.sectionHeaderTextColor?.toCSSColorValue() ?: SectionHeaderTextColorValue)
    SubtitleTextColor(theme.subtitleTextColor?.toCSSColorValue() ?: SubtitleTextColorValue)
    DestructiveTextColor(theme.destructiveTextColor?.toCSSColorValue() ?: DestructiveTextColorValue)
}

private fun dev.inmo.tgbotapi.webapps.Color.Hex.toCSSColorValue(): CSSColorValue {
    return Color(value)
}

private fun HEXColor.toCSSColorValue(): CSSColorValue {
    return Color(this)
}

class AppStyles(val themeParams: ThemeParams) : StyleSheet() {
    init {
        "body" style {
            applyThemeVariables(themeParams)
            fontFamily(
                "-apple-system",
                "BlinkMacSystemFont",
                "Segoe UI",
                "Roboto",
                "Helvetica",
                "Arial",
                "sans-serif",
                "Apple Color Emoji",
                "Segoe UI Emoji",
                "Segoe UI Symbol"
            )
            backgroundColor(TMAVariables.BackgroundColor.value())
            color(TMAVariables.TextColor.value())
        }
        "a" style {
            color(TMAVariables.LinkColor.value())
        }
        "button" style {
            color(TMAVariables.ButtonTextColor.value())
            backgroundColor(TMAVariables.ButtonColor.value())
        }
    }
}