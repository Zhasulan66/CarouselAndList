package com.zhasu.carouselandlist.presentation.components.carousel

import com.google.android.material.tabs.TabLayoutMediator
import com.zhasu.carouselandlist.databinding.ActivityMainBinding
import com.zhasu.carouselandlist.domain.model.NatureItem

class CarouselManager(
    private val binding: ActivityMainBinding,
    private val initialItems: List<NatureItem>
) {
    private lateinit var adapter: CarouselAdapter

    fun setup() {
        adapter = CarouselAdapter(initialItems.map { it.image })
        binding.viewPagerCarousel.adapter = adapter

        TabLayoutMediator(binding.carouselIndicator, binding.viewPagerCarousel) { _, _ ->
        }.attach()
    }

    fun updateCarousel(newList: List<NatureItem>) {
        adapter.updateData(newList.map { it.image })
    }
}