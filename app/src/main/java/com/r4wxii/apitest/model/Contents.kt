package com.r4wxii.apitest.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contents (
    val id: String,
    val title: String,
    @SerialName("items")
    val entries: List<Entry>,
)