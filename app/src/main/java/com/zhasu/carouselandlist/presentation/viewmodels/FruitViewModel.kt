package com.zhasu.carouselandlist.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.zhasu.carouselandlist.domain.model.NatureItem
import com.zhasu.carouselandlist.domain.repository.FruitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FruitViewModel @Inject constructor(
    private val repository: FruitRepository
) : ViewModel() {

    private val _fruits = MutableStateFlow<List<NatureItem>>(emptyList())
    val fruits: StateFlow<List<NatureItem>> = _fruits.asStateFlow()

    init {
        loadFruits()
    }

    private fun loadFruits() {
        _fruits.value = repository.getAllFruits()
    }
}