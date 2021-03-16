package com.example.mylist.ui.main

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.R
import com.example.mylist.adapter.PaisesAdapter
import com.example.mylist.databinding.ActivityMainBinding
import com.example.mylist.model.Pais

class MainActivity : AppCompatActivity(), MainListener {

    private val adapterPaises = PaisesAdapter()
    private var listaPaises: RecyclerView? = null
    private var searchView: SearchView? = null
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchView = findViewById(R.id.searchView)
        initViewModel()
        setupRecyclerView()

    }

    private fun initViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel =
                ViewModelProviders.of(this, ViewModelFactory()).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.listener = this

        listaPaises = binding.listPaises

        viewModel.initViewModel()
    }

    private fun setupRecyclerView() {
        listaPaises?.adapter = adapterPaises
        val manager = androidx.recyclerview.widget.LinearLayoutManager(this@MainActivity)
        listaPaises?.layoutManager = manager
    }

    override fun onSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapterPaises.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapterPaises.filter.filter(newText)
                return true
            }

        })
    }


    override fun onSetList() {
        val observableList = Observer<List<Pais>> { pais ->
            adapterPaises.items = pais
            adapterPaises.paisItems = pais
            adapterPaises.notifyDataSetChanged()
        }
        viewModel.list.observe(this, observableList)
    }
}


