package com.github.frozencure.helix.http.model.array

import kotlinx.serialization.Serializable

@Serializable
data class Pagination(val cursor: String? = null) {

    fun asPair(): Pair<String, String?> = Pair("cursor", cursor)
}