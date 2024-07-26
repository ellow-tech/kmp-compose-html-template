import dev.inmo.tgbotapi.webapps.webApp
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

actual fun HttpClientConfig<HttpClientEngineConfig>.authConfig() {
    defaultRequest {
        header("tma-data", webApp.initData)
    }
}