package com.zhasu.carouselandlist.presentation.components.searchbar

import androidx.core.widget.addTextChangedListener
import com.zhasu.carouselandlist.databinding.ActivityMainBinding

class SearchManager(
    private val binding: ActivityMainBinding,
    private val onFilter: (String) -> Unit
) {
    fun setup() {
        binding.searchBar.addTextChangedListener { text ->
            onFilter(text?.toString() ?: "")
        }
    }
}