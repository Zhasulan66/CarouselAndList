package com.zhasu.carouselandlist.presentation.components.naturelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zhasu.carouselandlist.R
import com.zhasu.carouselandlist.domain.model.NatureItem

class NatureAdapter : ListAdapter<NatureItem, NatureAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.tvItemTitle)
        val subtitle = view.findViewById<TextView>(R.id.tvItemSubtitle)
        val image = view.findViewById<ImageView>(R.id.ivItemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nature, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.title.text = item.title
        holder.subtitle.text = item.subtitle
        holder.image.setImageResource(item.image)
    }

    object DiffCallback : DiffUtil.ItemCallback<NatureItem>() {
        override fun areItemsTheSame(old: NatureItem, new: NatureItem) = old.id == new.id
        override fun areContentsTheSame(old: NatureItem, new: NatureItem) = old == new
    }
}