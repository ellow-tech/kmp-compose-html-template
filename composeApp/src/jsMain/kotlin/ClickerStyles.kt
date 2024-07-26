import org.jetbrains.compose.web.css.*

object ClickerStyles : StyleSheet() {

    val MainContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(100.vw)
        maxWidth(100.vw)
        height(100.vh)
        alignItems(AlignItems.Center)
    }

    val ClickerBlock by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        textAlign("center")
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.Center)
        width(100.percent)
        height(100.percent)
    }

    val MainImage by style {
        width(150.px)
        height(150.px)
    }

    val UserInfo by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(0.5.cssRem)
        marginTop(0.5.cssRem)
        width(90.percent)
        padding(0.5.cssRem)
        backgroundColor(TMAVariables.SectionBackgroundColor.value())
        borderWidth(0.px)
        borderRadius(15.px)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
    }

    val UserBlock by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(0.5.cssRem)
    }

    val UserInfoName by style {
        fontSize(1.cssRem)
        color(TMAVariables.TextColor.value())
        margin(0.px)
    }

    val UserInfoId by style {
        fontSize(0.8.cssRem)
        color(TMAVariables.SubtitleTextColor.value())
    }

    val PayButton by style {
        borderWidth(0.px)
        borderRadius(15.px)
        padding("5px 15px".unsafeCast<CSSNumeric>())
    }

}