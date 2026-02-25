package com.zhasu.carouselandlist.presentation.components.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.zhasu.carouselandlist.R
import com.zhasu.carouselandlist.domain.model.NatureItem

class StatsBottomSheet(private val items: List<NatureItem>) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_bottom_sheet, container, false)

        val tvItemCount = view.findViewById<TextView>(R.id.tvItemCount)
        val tvCharStats = view.findViewById<TextView>(R.id.tvCharStats)

        tvItemCount.text = "Total Items: ${items.size}"

        val top3 = items.flatMap { it.title.lowercase().filter { char -> char.isLetter() }.toList() }
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedByDescending { it.second }
            .take(3)

        val statsBuilder = StringBuilder()
        top3.forEach { (char, count) ->
            statsBuilder.append("$char = $count\n")
        }

        tvCharStats.text = statsBuilder.toString()

        return view
    }
}
