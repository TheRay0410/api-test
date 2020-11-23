package com.r4wxii.apitest.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.r4wxii.apitest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment(layoutId: Int = R.layout.main_fragment) : Fragment(layoutId) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel>()

}