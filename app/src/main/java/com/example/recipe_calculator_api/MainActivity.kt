package com.example.recipe_calculator_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe_calculator_api.data.User
import com.example.recipe_calculator_api.databinding.ActivityMainBinding

import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  recyclerViewAdapter: RecyclerViewAdapter
    private var userList= ArrayList<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializelist()
        initUserRecyclerView()

    }

    private fun initUserRecyclerView() {
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerViewAdapter.submitList(this.userList)
        binding.myRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerViewAdapter
        }

    }

     fun initializelist() {
         for ( i in 1..10){
             var user =User(name = "유청규 $i", email= "dbcjdrb$i@naver.com")
             this.userList.add(user)
         }
    }
}