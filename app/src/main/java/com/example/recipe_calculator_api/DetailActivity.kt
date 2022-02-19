package com.example.recipe_calculator_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recipe_calculator_api.databinding.ActivityDeatilBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeatilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDeatilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        binding.textView.text = name
        binding.textView2.text = email
    }
}