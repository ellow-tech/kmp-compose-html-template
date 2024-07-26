import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.inmo.tgbotapi.webapps.webApp

// Don't use in real code
enum class Screen {
    CLICKER,
    FRIENDS_LIST,
}

// Don't use in real code
var currentScreen by mutableStateOf(Screen.CLICKER)

@Composable
fun App() {
    when (currentScreen) {
        Screen.CLICKER -> ClickerScreen(
            onFriendsList = {
                currentScreen = Screen.FRIENDS_LIST
            }
        )

        Screen.FRIENDS_LIST -> FriendsListScreen(
            onBack = {
                currentScreen = Screen.CLICKER
            },
        )
    }
}