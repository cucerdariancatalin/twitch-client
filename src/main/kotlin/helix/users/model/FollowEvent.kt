package helix.users.model


import helix.http.model.AbstractResource
import helix.util.DateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class FollowEvent(
    @SerialName("from_id")
    val fromUserId: String,
    @SerialName("from_name")
    val fromUserName: String,
    @SerialName("to_id")
    val toUserId: String,
    @SerialName("to_name")
    val toUserName: String,
    @SerialName("followed_at")
    @Serializable(with = DateSerializer::class)
    val followedAt: Date
) : AbstractResource()