import org.jetbrains.compose.web.css.*

object AppStyles: StyleSheet() {

    val MainContainer by style {
        display(DisplayStyle.Flex)
        width(100.vw)
        height(100.vh)
        textAlign("center")
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.Center)
    }

}