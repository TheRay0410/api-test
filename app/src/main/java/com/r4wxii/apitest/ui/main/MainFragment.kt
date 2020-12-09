package com.r4wxii.apitest.ui.main

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.r4wxii.apitest.R
import com.r4wxii.apitest.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment(layoutId: Int = R.layout.main_fragment) : Fragment(layoutId) {
    private val viewModel by viewModels<MainViewModel>()

    private val listAdapter = FeedListAdapter {
        findNavController().navigate(MainFragmentDirections.actMainToFeed(it))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = MainFragmentBinding.bind(view)

        binding.feedList.adapter = listAdapter

        viewModel.feeds.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }
    }
}