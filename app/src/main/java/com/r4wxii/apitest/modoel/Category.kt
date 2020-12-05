package com.r4wxii.apitest.modoel

import kotlinx.serialization.Serializable

@Serializable
data class Category (
    val feeds: List<Feed>,
)