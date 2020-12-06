package com.r4wxii.apitest.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.r4wxii.apitest.model.Feed
import com.r4wxii.apitest.repository.FeedlyRepository

class MainViewModel @ViewModelInject constructor(
    private val repository: FeedlyRepository
) : ViewModel() {
    val feeds = liveData {
        emit(repository.getFeeds())
    }
}