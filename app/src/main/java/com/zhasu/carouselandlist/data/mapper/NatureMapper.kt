package com.zhasu.carouselandlist.data.mapper

import com.zhasu.carouselandlist.data.model.NatureItemEntity
import com.zhasu.carouselandlist.domain.model.NatureItem

fun NatureItemEntity.toDomain(): NatureItem {
    return NatureItem(
        id = this.id,
        title = this.name,
        subtitle = this.description,
        image = this.imageRes
    )
}