package com.r4wxii.apitest.api

import com.r4wxii.apitest.BuildConfig
import com.r4wxii.apitest.model.Category
import com.r4wxii.apitest.model.Contents
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.utils.*
import io.ktor.http.*
import kotlinx.serialization.Serializable
import java.net.URLEncoder
import javax.inject.Inject

interface FeedlyApi {
    suspend fun fetchCategories(): List<Category>
    suspend fun fetchContents(streamId: String): Contents
    suspend fun postMarkRead(entryId: String)
}

class FeedlyApiImpl @Inject constructor(private val httpClient: HttpClient) : FeedlyApi {
    override suspend fun fetchCategories(): List<Category> {
        return httpClient.get {
            url("https://cloud.feedly.com/v3/collections")
            header("Authorization", "OAuth ${BuildConfig.feeadlyApiToken}")
        }
    }

    override suspend fun fetchContents(streamId: String): Contents {
        return httpClient.get {
            val encodedId = URLEncoder.encode(streamId, "utf-8")
            url("https://cloud.feedly.com/v3/streams/$encodedId/contents?unreadOnly=true&count=100")
            headers {
                append("Authorization", "OAuth ${BuildConfig.feeadlyApiToken}")
            }
        }
    }

    override suspend fun postMarkRead(entryId: String) {
        return httpClient.post {
            url("https://cloud.feedly.com/v3/markers")
            contentType(ContentType.Application.Json)
            headers {
                append("Authorization", "OAuth ${BuildConfig.feeadlyApiToken}")
            }
            body = ReadEntry(entryIds = listOf(entryId))
        }
    }

    @Serializable
    private data class ReadEntry(
        val action: String = "markAsRead",
        val type: String = "entries",
        val entryIds: List<String>,
    )
}