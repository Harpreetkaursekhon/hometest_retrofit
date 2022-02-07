package com.myapp.kundli.redbubbletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapp.kundli.redbubbletest.adapter.HomeAdapter
import com.myapp.kundli.redbubbletest.model.Home
import com.myapp.kundli.retrofitwithkotlincoroutines.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var homeAdapter:HomeAdapter
    private lateinit var homeViewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        homeViewModel= ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel.getPost()
        homeViewModel.postmutablelivedata.observe(this,{
            homeAdapter.setData(it.workDetails.availableProducts)
        })
    }

    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        homeAdapter= HomeAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter= homeAdapter
        }

    }
}