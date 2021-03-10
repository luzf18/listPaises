package com.example.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.model.Pais

class MainActivity : AppCompatActivity() {

    private val adapterPaises = PaisesAdapter()
    private var list: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById(R.id.listPaises)
        val paises: List<Pais> =
            listOf(Pais("Brasil"), Pais("Alemanha"), Pais("Estados Unidos"), Pais("Russia"))
        adapterPaises.items = paises
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(list) {
            this?.adapter = adapterPaises
            val manager = androidx.recyclerview.widget.LinearLayoutManager(this?.context)
            list?.layoutManager = manager
        }
    }
}