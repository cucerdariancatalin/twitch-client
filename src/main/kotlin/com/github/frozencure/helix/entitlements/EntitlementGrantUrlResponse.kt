package com.github.frozencure.helix.entitlements

import com.github.frozencure.helix.entitlements.model.EntitlementUrl
import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.SingleResponse
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking


class EntitlementGrantUrlResponse(httpResponse: HttpResponse) : SingleResponse<EntitlementUrl>(httpResponse) {

    override val helixArrayDTO: HelixArrayDTO<EntitlementUrl> = runBlocking {
        httpResponse.receive<HelixArrayDTO<EntitlementUrl>>()
    }
}