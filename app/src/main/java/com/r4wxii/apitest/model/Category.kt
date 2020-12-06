package com.r4wxii.apitest.model

import kotlinx.serialization.Serializable

@Serializable
data class Category (
    val feeds: List<Feed>,
)