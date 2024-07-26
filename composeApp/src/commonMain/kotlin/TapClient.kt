import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

// don't use in real code!
object TapClient {

    private const val SERVER_URL = "https://37da-5-128-39-110.ngrok-free.app"

    private val client: HttpClient = HttpClient(TapClientEngine) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
        authConfig()
    }

    suspend fun sendCurrentScore(score: Long) {
        client.post("$SERVER_URL/score/") {
            setBody(SendCurrentScoreRequest(score))
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun fetchCurrentScore(): Long {
        return client.get("$SERVER_URL/score/").body<GetCurrentScoreResponse>().score
    }

    suspend fun fetchFriendsList(): List<FriendInfo> {
        return client.get("$SERVER_URL/friends/").body<GetFriendsListResponse>().friends
    }

    suspend fun fetchUpgradeLink(): String {
        return client.post("$SERVER_URL/upgrade/").body<UpgradeResponse>().invoiceLink
    }

}

@Serializable
class UpgradeResponse(
    @SerialName("invoice_link")
    val invoiceLink: String,
)

@Serializable
class SendCurrentScoreRequest(
    val score: Long,
)

@Serializable
class GetCurrentScoreResponse(
    val score: Long,
)

@Serializable
class GetFriendsListResponse(
    val friends: List<FriendInfo>,
)

@Serializable
data class FriendInfo(
    val id: Long,
    @SerialName("first_name")
    val firstName: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("is_invitation")
    val isInviteYou: Boolean = false,
)