package com.r4wxii.apitest.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.r4wxii.apitest.model.Entry
import com.r4wxii.apitest.repository.FeedlyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect

class EntryViewModel @ViewModelInject constructor(
    private val repository: FeedlyRepository
) : ViewModel() {
    private val streamId = MutableStateFlow("")
    val entries = liveData(viewModelScope.coroutineContext) {
        streamId.collect {
            this.emit(repository.getEntries(it))
        }
    }

    fun setStreamId(streamId: String) {
        this.streamId.value = streamId
    }
}