import org.jetbrains.compose.web.css.*

object FriendsListStyle : StyleSheet() {

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(100.vw)
    }

    val FriendBlock by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        padding(1.cssRem)
    }

}