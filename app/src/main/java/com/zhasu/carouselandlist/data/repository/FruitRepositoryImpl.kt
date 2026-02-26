package com.zhasu.carouselandlist.data.repository

import com.zhasu.carouselandlist.R
import com.zhasu.carouselandlist.domain.model.NatureItem
import com.zhasu.carouselandlist.domain.repository.FruitRepository

class FruitRepositoryImpl() : FruitRepository {
    private val listData = listOf(
        NatureItem(1, "Apple", "List item subtitle", R.drawable.nature1),
        NatureItem(2, "Banana", "List item subtitle", R.drawable.nature2),
        NatureItem(3, "Orange", "List item subtitle", R.drawable.nature1),
        NatureItem(4, "Peach", "List item subtitle", R.drawable.nature2),
        NatureItem(5, "Apricot", "List item subtitle", R.drawable.nature1),
        NatureItem(6, "Apple", "List item subtitle", R.drawable.nature2),
        NatureItem(7, "Pear", "List item subtitle", R.drawable.nature1),
        NatureItem(8, "Orange", "List item subtitle", R.drawable.nature2),
        NatureItem(9, "Banana", "List item subtitle", R.drawable.nature1),
        NatureItem(10, "Apple", "List item subtitle", R.drawable.nature2),
    )

    override fun getAllFruits(): List<NatureItem> = listData
}