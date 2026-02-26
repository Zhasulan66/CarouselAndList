package com.zhasu.carouselandlist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.zhasu.carouselandlist.databinding.ActivityMainBinding
import com.zhasu.carouselandlist.presentation.components.bottomsheet.FabManager
import com.zhasu.carouselandlist.presentation.components.carousel.CarouselManager
import com.zhasu.carouselandlist.presentation.components.naturelist.ListManager
import com.zhasu.carouselandlist.presentation.components.searchbar.SearchManager
import com.zhasu.carouselandlist.presentation.viewmodels.NatureViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: NatureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Managers
        val carouselManager = CarouselManager(binding, emptyList())
        val listManager = ListManager(binding, emptyList())
        carouselManager.setup()
        listManager.setup()

        lifecycleScope.launch {
            viewModel.filteredList.collect { newList ->
                carouselManager.updateCarousel(newList)
                listManager.updateList(newList)
            }
        }

        SearchManager(binding) { query ->
            viewModel.filter(query)
        }.setup()

        FabManager(binding, supportFragmentManager) {
            viewModel.filteredList.value
        }.setup()
    }
}