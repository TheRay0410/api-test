package com.r4wxii.apitest.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.r4wxii.apitest.repository.FeedlyRepository
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(
    private val repository: FeedlyRepository
): ViewModel() {
    // TODO: Implement the ViewModel
}