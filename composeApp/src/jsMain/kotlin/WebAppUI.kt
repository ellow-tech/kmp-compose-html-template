import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import dev.inmo.tgbotapi.webapps.MainButtonParams
import dev.inmo.tgbotapi.webapps.setParams
import dev.inmo.tgbotapi.webapps.webApp

@Composable
fun WebAppMainButton(
    text: String,
    onClick: () -> Unit,
    visible: Boolean = true,
    active: Boolean? = undefined,
    loading: Boolean = false,
    loadingLeaveActive: Boolean = false,
    hideOnDispose: Boolean = true, // use if next screen has MainButton too
    color: String? = undefined,
    textColor: String? = undefined,
) {
    DisposableEffect(visible) {
        if (visible) {
            webApp.mainButton.show()
        } else {
            webApp.mainButton.hide()
        }
        onDispose {
            if (hideOnDispose)
                webApp.mainButton.hide()
        }
    }
    DisposableEffect(
        keys = arrayOf(
            onClick, text, color, textColor, visible, active,
            loading, loadingLeaveActive
        ),
    ) {
        webApp.mainButton.onClick(onClick)
        webApp.mainButton.setParams(
            MainButtonParams(
                text = text,
                color = color,
                textColor = textColor,
                isActive = active,
                isVisible = visible,
            )
        )
        if (loading)
            webApp.mainButton.showProgress(leaveActive = loadingLeaveActive)
        else
            webApp.mainButton.hideProgress()
        onDispose {
            webApp.mainButton.offClick(onClick)
        }
    }
}

@Composable
fun WebAppBackButton(
    onClick: () -> Unit,
) {
    DisposableEffect(Unit) {
        webApp.backButton.onClick(onClick)
        webApp.backButton.show()
        onDispose {
            webApp.backButton.hide()
            webApp.backButton.offClick(onClick)
        }
    }
}