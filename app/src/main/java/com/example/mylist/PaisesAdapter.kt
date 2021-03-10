package com.example.mylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.model.Pais
import kotlin.properties.Delegates

class PaisesAdapter : RecyclerView.Adapter<PaisesViewHolder>() {
    var items: List<Pais> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    val paisItems: List<Pais> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    val filterItems: List<Pais> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisesViewHolder {
        return PaisesViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_pais, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PaisesViewHolder, position: Int) {
        val pais = items[position]
        holder.bind(pais)
    }
}

class PaisesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Pais) {
        with(itemView) {
            var textView = findViewById<TextView>(R.id.textView)
            textView.text = item.name

        }
    }
}
