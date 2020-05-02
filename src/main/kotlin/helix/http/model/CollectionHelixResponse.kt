package helix.http.model

import io.ktor.client.HttpClient
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request

abstract class CollectionHelixResponse<T : AbstractResource>(
    httpResponse: HttpResponse,
    protected val httpClient: HttpClient
) :
    HelixResponse<T>(httpResponse) {

    val data: Collection<T>
        get() = helixDTO.data

    val pagination: Pagination?
        get() = helixDTO.pagination

    val total: Long?
        get() = helixDTO.total

    protected suspend fun nextPageHttpResponse(): HttpResponse? =
        pagination?.let {
            httpClient.request<HttpResponse> {
                url(httpResponse.request.url)
                parameter(it.asPair().first, it.asPair().second)
                headers { httpResponse.request.headers }
                method = httpResponse.request.method
            }
        }

    abstract suspend fun nextPage(): CollectionHelixResponse<T>?

}