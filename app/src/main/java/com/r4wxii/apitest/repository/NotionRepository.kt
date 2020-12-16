package com.r4wxii.apitest.repository

import com.r4wxii.apitest.api.NotionApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

interface NotionRepository {
    suspend fun addWebClip(url: String, title: String): Flow<Boolean>
}

class NotionRepositoryImpl @Inject constructor(private val api: NotionApi) : NotionRepository {
    override suspend fun addWebClip(url: String, title: String): Flow<Boolean> = flowOf(api.postWebClip(url, title))
}