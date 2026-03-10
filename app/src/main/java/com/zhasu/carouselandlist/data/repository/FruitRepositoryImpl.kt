package com.zhasu.carouselandlist.data.repository

import com.zhasu.carouselandlist.R
import com.zhasu.carouselandlist.data.mapper.toDomain
import com.zhasu.carouselandlist.data.model.NatureItemEntity
import com.zhasu.carouselandlist.domain.model.NatureItem
import com.zhasu.carouselandlist.domain.repository.FruitRepository
import javax.inject.Inject

class FruitRepositoryImpl @Inject constructor() : FruitRepository {
    private val listData = listOf(
        NatureItemEntity(1, "Apple", "List item subtitle", R.drawable.nature1),
        NatureItemEntity(2, "Banana", "List item subtitle", R.drawable.nature2),
        NatureItemEntity(3, "Orange", "List item subtitle", R.drawable.nature1),
        NatureItemEntity(4, "Peach", "List item subtitle", R.drawable.nature2),
        NatureItemEntity(5, "Apricot", "List item subtitle", R.drawable.nature1),
        NatureItemEntity(6, "Apple", "List item subtitle", R.drawable.nature2),
        NatureItemEntity(7, "Pear", "List item subtitle", R.drawable.nature1),
        NatureItemEntity(8, "Orange", "List item subtitle", R.drawable.nature2),
        NatureItemEntity(9, "Banana", "List item subtitle", R.drawable.nature1),
        NatureItemEntity(10, "Apple", "List item subtitle", R.drawable.nature2),
    )


    override fun getAllFruits(): List<NatureItem> {
        return listData.map { it.toDomain() }
    }
}