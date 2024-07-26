import dev.inmo.tgbotapi.webapps.webApp
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "app") {
        Style(AppStyles(webApp.themeParams))
        Style(ClickerStyles)
        Style(FriendsListStyle)

        App()
    }
}