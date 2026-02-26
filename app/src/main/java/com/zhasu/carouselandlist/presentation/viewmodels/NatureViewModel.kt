package com.zhasu.carouselandlist.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.zhasu.carouselandlist.domain.model.NatureItem
import com.zhasu.carouselandlist.domain.repository.FruitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NatureViewModel @Inject constructor(
    private val repository: FruitRepository
) : ViewModel() {

    private val allItems = repository.getAllFruits()

    private val _filteredList = MutableStateFlow(allItems)
    val filteredList: StateFlow<List<NatureItem>> = _filteredList

    fun filter(query: String) {
        _filteredList.value = if (query.isEmpty()) {
            allItems
        } else {
            allItems.filter { it.title.contains(query, ignoreCase = true) }
        }
    }
}