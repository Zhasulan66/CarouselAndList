package com.zhasu.carouselandlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhasu.carouselandlist.data.local.listData
import com.zhasu.carouselandlist.databinding.ActivityMainBinding
import com.zhasu.carouselandlist.presentation.components.bottomsheet.FabManager
import com.zhasu.carouselandlist.presentation.components.carousel.CarouselManager
import com.zhasu.carouselandlist.presentation.components.naturelist.ListManager
import com.zhasu.carouselandlist.presentation.components.searchbar.SearchManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentFilteredList = listData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init Managers
        val carouselManager = CarouselManager(binding, listData)
        val listManager = ListManager(binding, listData)

        carouselManager.setup()
        listManager.setup()

        FabManager(binding, supportFragmentManager) { currentFilteredList }.setup()

        SearchManager(binding) { query ->
            currentFilteredList = listData.filter { it.title.contains(query, true) }

            carouselManager.updateCarousel(currentFilteredList)
            listManager.updateList(currentFilteredList)
        }.setup()
    }
}