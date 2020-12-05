package com.r4wxii.apitest.api

import com.r4wxii.apitest.modoel.Category
import com.r4wxii.apitest.modoel.Feed
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

interface FeedlyApi {
    suspend fun fetchCategories(token: String): List<Category>
}

class FeedlyApiImpl @Inject constructor(private val httpClient: HttpClient) : FeedlyApi {
    override suspend fun fetchCategories(token: String): List<Category> {
        return httpClient.get {
            url("https://cloud.feedly.com/v3/collections")
            header("Authorization", "OAuth $token")
        }
    }
}