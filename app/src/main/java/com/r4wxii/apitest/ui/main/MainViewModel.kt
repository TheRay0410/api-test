package com.r4wxii.apitest.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.r4wxii.apitest.modoel.Feed
import com.r4wxii.apitest.repository.FeedlyRepository

class MainViewModel @ViewModelInject constructor(
    private val repository: FeedlyRepository
) : ViewModel() {
    suspend fun getFeeds(): List<Feed> {
        return repository.getFeeds()
    }
}