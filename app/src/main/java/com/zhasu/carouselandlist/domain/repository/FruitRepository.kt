package com.zhasu.carouselandlist.domain.repository

import com.zhasu.carouselandlist.domain.model.NatureItem

interface FruitRepository {
    fun getAllFruits(): List<NatureItem>
}