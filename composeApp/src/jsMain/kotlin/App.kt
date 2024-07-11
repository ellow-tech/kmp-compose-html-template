import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text

@Composable
fun App() {
    Div(
        attrs = {
            classes(AppStyles.MainContainer)
        }
    ) {
        H2 {
            Text("This is my Kotlin ${Platform.name} application")
        }
    }
}