package com.r4wxii.apitest.repository

import com.r4wxii.apitest.api.NotionApi
import javax.inject.Inject

interface NotionRepository {
    suspend fun addWebClip(url: String, title: String)
}

class NotionRepositoryImpl @Inject constructor(private val api: NotionApi) : NotionRepository {
    override suspend fun addWebClip(url: String, title: String) = api.postWebClip(url, title)
}