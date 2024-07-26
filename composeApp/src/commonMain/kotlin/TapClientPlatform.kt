import io.ktor.client.*
import io.ktor.client.engine.*

expect val TapClientEngine: HttpClientEngineFactory<*>

expect fun HttpClientConfig<HttpClientEngineConfig>.authConfig()