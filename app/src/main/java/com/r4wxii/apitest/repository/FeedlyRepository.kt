package com.r4wxii.apitest.repository

import com.r4wxii.apitest.api.FeedlyApi
import com.r4wxii.apitest.modoel.Category
import com.r4wxii.apitest.modoel.Feed
import javax.inject.Inject

interface FeedlyRepository {
    suspend fun getFeeds(token: String): List<Feed>
}

class FeedlyRepositoryImpl @Inject constructor(private val api: FeedlyApi) : FeedlyRepository {
    override suspend fun getFeeds(token: String): List<Feed> = api.fetchCategories(token).first().feeds
}