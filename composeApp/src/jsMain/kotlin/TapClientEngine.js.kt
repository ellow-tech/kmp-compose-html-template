import io.ktor.client.engine.*
import io.ktor.client.engine.js.*

actual val TapClientEngine: HttpClientEngineFactory<*> = Js