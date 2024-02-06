package com.example.mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.adapter.ResponseListAdapter
import com.example.mvvm.commom.ERROR_DATA
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    lateinit var recyclerAdapter: ResponseListAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null){
                recyclerAdapter.setResponseList(it)
                recyclerAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this, ERROR_DATA,Toast.LENGTH_LONG).show()
            }
        })

        mainActivityViewModel.makeAPICall()
    }

    private fun initRecyclerView(){
        binding.responseListRecyclerview.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = ResponseListAdapter()
        binding.responseListRecyclerview.adapter = recyclerAdapter
    }
}