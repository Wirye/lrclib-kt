package com.github.wirye.lrclibkt.api

import com.github.wirye.lrclibkt.LrclibRateLimiter
import com.github.wirye.lrclibkt.exception.LrclibException
import com.github.wirye.lrclibkt.model.LrclibTrack
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode

class SearchApi(
    private val httpClient: HttpClient
) {
    suspend fun searchByMeta(
        trackName: String,
        artist: String? = null,
        album: String? = null,
        duration: Float? = null,
    ): Result<LrclibTrack?> = runCatching {
        LrclibRateLimiter.acquire()

        val result = httpClient.get("https://lrclib.net/api/get") {
            url {
                parameters.append("track_name", trackName)

                if (artist != null) {
                    parameters.append("artist_name", artist)
                }

                if (album != null) {
                    parameters.append("album_name", album)
                }

                if (duration != null) {
                    parameters.append("duration", duration.toString())
                }
            }
        }

        when (result.status) {
            HttpStatusCode.OK -> result.body()

            HttpStatusCode.NotFound -> throw LrclibException.NotFoundException()
            HttpStatusCode.BadRequest -> throw LrclibException.ValidationErrorException(result.body())

            else -> throw LrclibException.ServerErrorException(result.status.value)
        }
    }

    suspend fun searchById(
        id: Long
    ): Result<LrclibTrack?> = runCatching {
        LrclibRateLimiter.acquire()

        val result = httpClient.get("https://lrclib.net/api/get/$id")

        when (result.status) {
            HttpStatusCode.OK -> result.body()

            HttpStatusCode.NotFound -> throw LrclibException.NotFoundException()
            HttpStatusCode.BadRequest -> throw LrclibException.ValidationErrorException(result.body())

            else -> throw LrclibException.ServerErrorException(result.status.value)
        }
    }
}
