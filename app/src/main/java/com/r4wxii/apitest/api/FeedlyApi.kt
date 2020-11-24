package com.r4wxii.apitest.api

import io.ktor.client.*
import javax.inject.Inject

interface FeedlyApi

class FeedlyApiImpl @Inject constructor (private val httpClient: HttpClient) : FeedlyApi {

}