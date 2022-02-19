package com.example.recipe_calculator_api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.recipe_calculator_api.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val secondIntent =  intent

        binding.textView.text = secondIntent.getStringExtra("name")
        binding.textView2.text = secondIntent.getStringExtra("title")
    }
}