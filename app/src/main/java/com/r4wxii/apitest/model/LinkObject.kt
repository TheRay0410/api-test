package com.r4wxii.apitest.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LinkObject (
    @SerialName("href")
    val link: String,
)