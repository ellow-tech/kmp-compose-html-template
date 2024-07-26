import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import dev.inmo.tgbotapi.webapps.webApp
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Text

// Use build config instead
private const val AppLink = "https://t.me/tapalka_kmp_bot/app"

private const val ShareMessage =
    "%D0%9F%D0%BE%D0%BF%D1%80%D0%BE%D0%B1%D1%83%D0%B9+%D1%8D%D1%82%D0%BE%D1%82+%D0%BD%D0%BE%D0%B2%D1%8B%D0%B9+%D0%BA%D0%BB%D0%B8%D0%BA%D0%B5%D1%80%21"

private fun buildInviteLink(telegramId: Long): String {
    return "$AppLink?startapp=ref_$telegramId"
}

private fun buildShareLink(telegramId: Long): String {
    return "https://t.me/share/url?url=${buildInviteLink(telegramId)}&text=${ShareMessage}"
}

@Composable
fun FriendsListScreen(
    onBack: () -> Unit,
) {
    val friendsList = remember { mutableStateListOf<FriendInfo>() }
    LaunchedEffect(Unit) {
        try {
            friendsList.addAll(TapClient.fetchFriendsList())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    WebAppBackButton(onClick = onBack)
    WebAppMainButton(
        text = "Пригласить друзей",
        hideOnDispose = false,
        onClick = {
            val id = webApp.initDataUnsafe.user?.id ?: return@WebAppMainButton
            webApp.openTelegramLink(buildShareLink(id.long))
        }
    )
    Div(
        attrs = {
            classes(FriendsListStyle.Container)
        }
    ) {
        if (friendsList.isEmpty()) {
            H4 {
                Text("У тебя пока нет друзей...")
            }
        } else {
            friendsList.forEach {
                Friend(it)
            }
        }
    }
}

@Composable
fun Friend(friend: FriendInfo) {
    Div(
        attrs = {
            classes(FriendsListStyle.FriendBlock)
        }
    ) {
        Text("${friend.username} (${friend.id})")
    }
}