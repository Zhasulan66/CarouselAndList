package com.zhasu.carouselandlist.presentation.components.bottomsheet

import androidx.fragment.app.FragmentManager
import com.zhasu.carouselandlist.databinding.ActivityMainBinding
import com.zhasu.carouselandlist.domain.model.NatureItem

class FabManager(
    private val binding: ActivityMainBinding,
    private val fragmentManager: FragmentManager,
    private val getCurrentList: () -> List<NatureItem>
) {
    fun setup() {
        binding.fabStats.setOnClickListener {
            val currentData = getCurrentList()
            val bottomSheet = StatsBottomSheet(currentData)
            bottomSheet.show(fragmentManager, "StatsSheet")
        }
    }
}