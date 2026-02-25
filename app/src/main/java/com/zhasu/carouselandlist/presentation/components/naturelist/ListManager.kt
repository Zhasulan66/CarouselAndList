package com.zhasu.carouselandlist.presentation.components.naturelist

import androidx.recyclerview.widget.LinearLayoutManager
import com.zhasu.carouselandlist.databinding.ActivityMainBinding
import com.zhasu.carouselandlist.domain.model.NatureItem

class ListManager(
    private val binding: ActivityMainBinding,
    private val initialItems: List<NatureItem>
) {
    private val adapter = NatureAdapter()

    fun setup() {
        binding.recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerView.adapter = adapter
        adapter.submitList(initialItems)
    }

    fun updateList(newList: List<NatureItem>) {
        adapter.submitList(newList)
    }
}