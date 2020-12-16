package com.r4wxii.apitest.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.r4wxii.apitest.R
import com.r4wxii.apitest.databinding.EntryFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EntryFragment(layoutId: Int = R.layout.entry_fragment) : Fragment(layoutId) {
    private val navArgs by navArgs<EntryFragmentArgs>()
    private val viewModel by viewModels<EntryViewModel>()

    private val listAdapter = EntryListAdapter { url, title, entryId ->
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.addWebClip(url, title, entryId)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = EntryFragmentBinding.bind(view)
        viewModel.setStreamId(navArgs.streamId)

        binding.entryList.adapter = listAdapter

        viewModel.entries.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }
    }
}