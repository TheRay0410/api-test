package com.r4wxii.apitest.modoel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Feed(
    val id: String,
    val title: String,
    @SerialName("visualUrl")
    val imageUrl: String? = null,
)