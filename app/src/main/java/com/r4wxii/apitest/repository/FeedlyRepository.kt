package com.r4wxii.apitest.repository

import com.r4wxii.apitest.api.FeedlyApi
import javax.inject.Inject

interface FeedlyRepository

class FeedlyRepositoryImpl @Inject constructor(private val api: FeedlyApi) : FeedlyRepository