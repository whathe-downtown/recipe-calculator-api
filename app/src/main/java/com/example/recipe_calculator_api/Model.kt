package com.example.recipe_calculator_api

import android.util.Log

class Model(var name: String? = null , var profileImage: String? = null) {
    val TAG: String ="로그"

    init {
        Log.d(TAG, "Model: Called")
    }
}