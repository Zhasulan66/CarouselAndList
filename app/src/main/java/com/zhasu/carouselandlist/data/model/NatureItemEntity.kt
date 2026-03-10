package com.zhasu.carouselandlist.data.model

import androidx.annotation.DrawableRes

data class NatureItemEntity(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val imageRes: Int
)