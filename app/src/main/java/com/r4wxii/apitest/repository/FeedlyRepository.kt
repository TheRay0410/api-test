package com.r4wxii.apitest.repository

import com.r4wxii.apitest.api.FeedlyApi
import com.r4wxii.apitest.model.Entry
import com.r4wxii.apitest.model.Feed
import javax.inject.Inject

interface FeedlyRepository {
    suspend fun getFeeds(): List<Feed>
    suspend fun getEntries(streamId: String): List<Entry>
    suspend fun markRead(entryId: String)
}

class FeedlyRepositoryImpl @Inject constructor(private val api: FeedlyApi) : FeedlyRepository {
    override suspend fun getFeeds(): List<Feed> = api.fetchCategories().first().feeds
    override suspend fun getEntries(streamId: String): List<Entry> = api.fetchContents(streamId).entries
    override suspend fun markRead(entryId: String) = api.postMarkRead(entryId)
}