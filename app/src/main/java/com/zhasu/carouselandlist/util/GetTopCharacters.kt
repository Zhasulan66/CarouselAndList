package com.zhasu.carouselandlist.util

import com.zhasu.carouselandlist.domain.model.NatureItem

fun getTopCharacters(items: List<NatureItem>): List<Pair<Char, Int>> {
    return items.flatMap { it.title.lowercase().filter { char -> char.isLetter() }.toList() }
        .groupingBy { it }
        .eachCount()
        .toList()
        .sortedByDescending { it.second }
        .take(3)
}