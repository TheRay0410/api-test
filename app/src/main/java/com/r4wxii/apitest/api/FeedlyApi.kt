package com.r4wxii.apitest.api

import com.r4wxii.apitest.BuildConfig
import com.r4wxii.apitest.model.Category
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

interface FeedlyApi {
    suspend fun fetchCategories(): List<Category>
}

class FeedlyApiImpl @Inject constructor(private val httpClient: HttpClient) : FeedlyApi {
    override suspend fun fetchCategories(): List<Category> {
        return httpClient.get {
            url("https://cloud.feedly.com/v3/collections")
            header("Authorization", "OAuth ${BuildConfig.feeadlyApiToken}")
        }
    }
}