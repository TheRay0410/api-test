package com.r4wxii.apitest.api

import com.r4wxii.apitest.BuildConfig
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

interface NotionApi {
    suspend fun postWebClip(pageUrl: String, pageTitle: String): Boolean
}

class NotionApiImpl @Inject constructor(private val httpClient: HttpClient) : NotionApi {
    override suspend fun postWebClip(pageUrl: String, pageTitle: String): Boolean {
        val response = httpClient.post<HttpResponse> {
            url("https://www.notion.so/api/v3/addWebClipperURLs")
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.Cookie, "token_v2=${BuildConfig.notionApiToken}")
            }
            body = WebClipContent(
                items = listOf(
                    PageItem(url = pageUrl, title = pageTitle)
                )
            )
        }
        return response.status == HttpStatusCode.OK
    }

    @Serializable
    private data class PageItem(val url: String, val title: String)

    @Serializable
    private data class WebClipContent(
        val type: String = "block",
        val blockId: String = BuildConfig.notionApiBlockId,
        val items: List<PageItem>,
        val from: String = "chrome",
    )
}