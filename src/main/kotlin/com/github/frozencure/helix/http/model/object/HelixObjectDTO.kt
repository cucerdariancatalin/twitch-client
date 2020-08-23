package com.github.frozencure.helix.http.model.`object`

import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HelixObjectDTO<T : AbstractResource>(
    @SerialName("data")
    val resource: T
)