package com.example.recipe_calculator_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe_calculator_api.data.User
import com.example.recipe_calculator_api.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  lateinit var myAdapter: MyAdapter

    var userList = ArrayList<User>()
    val TAG: String = "로그"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        for(i in 1..10){
            var user = User(name = "유청규 $i", email = "dbcjdrb$i@naver.com")
            this.userList.add(user)
        }
        binding.myRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
            adapter = myAdapter
        }
    }
}