package com.example.mylist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.R
import com.example.mylist.model.Pais
import com.example.mylist.utils.Contants.Constants.ALEMANHA
import com.example.mylist.utils.Contants.Constants.BRASIL
import com.example.mylist.utils.Contants.Constants.CHINA
import com.example.mylist.utils.Contants.Constants.DINAMARCA
import com.example.mylist.utils.Contants.Constants.ESTADOSUNIDOS
import com.example.mylist.utils.Contants.Constants.FRANCA
import com.example.mylist.utils.Contants.Constants.GRECIA
import com.example.mylist.utils.Contants.Constants.HOLANDA
import com.example.mylist.utils.Contants.Constants.IRLANDA
import com.example.mylist.utils.Contants.Constants.JAPAO
import com.example.mylist.utils.Contants.Constants.KOSOVO
import com.example.mylist.utils.Contants.Constants.LIBANO
import com.example.mylist.utils.Contants.Constants.MALDIVAS
import com.example.mylist.utils.Contants.Constants.NIGERIA
import com.example.mylist.utils.Contants.Constants.OMA
import com.example.mylist.utils.Contants.Constants.PORTUGAL
import com.example.mylist.utils.Contants.Constants.QATAR
import com.example.mylist.utils.Contants.Constants.RUSSIA
import com.example.mylist.utils.Contants.Constants.SANMARINO
import com.example.mylist.utils.Contants.Constants.TURQUIA
import com.example.mylist.utils.Contants.Constants.UCRANIA
import com.example.mylist.utils.Contants.Constants.VENEZUELA
import com.example.mylist.utils.Contants.Constants.ZAMBIA
import kotlin.properties.Delegates

class PaisesAdapter : RecyclerView.Adapter<PaisesViewHolder>(), Filterable {

    var items: List<Pais> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    var paisItems: List<Pais> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    var filterItems = ArrayList<Pais>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisesViewHolder {
        return PaisesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pais, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PaisesViewHolder, position: Int) {
        val atual = items[position]
        holder.bind(item = atual)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                filterItems = if (charSearch.isEmpty()) {
                    paisItems as ArrayList<Pais>
                } else {
                    val resultList = ArrayList<Pais>()
                    for (row in paisItems) {
                        if (row.name.
                            toLowerCase()
                                .contains(constraint.toString().toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResultList = FilterResults()
                filterResultList.values = filterItems
                return filterResultList
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                try {
                    items = results?.values as List<Pais>
                    notifyDataSetChanged()
                } catch (e: Exception) {
                    items = paisItems
                }
            }
        }
    }
}

class PaisesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Pais) {
        val namePais = itemView.findViewById<TextView>(R.id.name_pais)
        val hbPais = itemView.findViewById<TextView>(R.id.hb_pais)
        val cpPais = itemView.findViewById<TextView>(R.id.cp_pais)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        with(itemView) {
            namePais.text = item.name
            hbPais.text = item.habitantes
            cpPais.text = item.capital
            
            if (item.name == ALEMANHA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.alemanha)
            }

            if (item.name == BRASIL) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.brasil)
            }

            if (item.name == CHINA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.china)
            }
            if (item.name == DINAMARCA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.dinamarca)
            }
            if (item.name == ESTADOSUNIDOS) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.estados_unidos)
            }
            if (item.name == FRANCA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.franca)
            }
            if (item.name == GRECIA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.grecia)
            }
            if (item.name == HOLANDA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.holanda)
            }
            if (item.name == IRLANDA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.irlanda)
            }
            if (item.name == JAPAO) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.japao)
            }
            if (item.name == KOSOVO) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.kosovo)
            }
            if (item.name == LIBANO) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.libano)
            }
            if (item.name == MALDIVAS) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.maldivas)
            }
            if (item.name == NIGERIA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.nigeria)
            }
            if (item.name == OMA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.oma)
            }
            if (item.name == PORTUGAL) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.portugal)
            }
            if (item.name == QATAR) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.qatar)
            }
            if (item.name == RUSSIA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.russia)
            }
            if (item.name == SANMARINO) {
            imageView.background =
                context.resources.getDrawable(R.drawable.san_marino)
        }
            if (item.name == TURQUIA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.turquia)
            }
            if (item.name == UCRANIA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.ucrania)
            }
            if (item.name == VENEZUELA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.venezuela)
            }
            if (item.name == ZAMBIA) {
                imageView.background =
                    context.resources.getDrawable(R.drawable.zambia)
            }

        }

        }
    }

