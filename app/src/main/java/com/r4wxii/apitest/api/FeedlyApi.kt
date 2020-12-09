package com.r4wxii.apitest.api

import com.r4wxii.apitest.BuildConfig
import com.r4wxii.apitest.model.Category
import com.r4wxii.apitest.model.Contents
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.utils.*
import io.ktor.http.*
import java.net.URLEncoder
import javax.inject.Inject

interface FeedlyApi {
    suspend fun fetchCategories(): List<Category>
    suspend fun fetchContents(streamId: String): Contents
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
            url("https://cloud.feedly.com/v3/streams/$encodedId/contents")
            headers {
                append("Authorization", "OAuth ${BuildConfig.feeadlyApiToken}")
                append("unreadOnly", "true")
                append("count", "50")
            }
        }
    }
}