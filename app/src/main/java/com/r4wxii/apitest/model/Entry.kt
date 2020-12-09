package com.r4wxii.apitest.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Entry(
    val id: String,
    val title: String,
    @SerialName("alternate")
    val linkObjects: List<LinkObject>,
)