package com.example.recipe_calculator_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() , RecyclerviewInterface{

    val TAG: String = "로그"

    var modelList = ArrayList<Model>()

    private  lateinit var  recyclerAdapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: MainaActity - called")

        Log.d(TAG, "onCreate: this.model.size : ${this.modelList.size}")

        for(i in 1..10){
            var model = Model(name = "유청규 $i", profileImage = "https://yt3.ggpht.com/oLi5jJ2AKs_aYpR9UpUpu052M84WIE2j9cpnNb1VnpBHZMHVrTRPwrUIncJGu6--PVR-x-22=s48-c-k-c0x00ffffff-no-rj")
            this.modelList.add(model)
        }
        Log.d(TAG, "onCreate: this.model.size : ${this.modelList.size}")
        // 어답터 인스턴스 생성
        recyclerAdapter = RecyclerAdapter(this)
        recyclerAdapter.submitList(this.modelList)

        my_recycler_view.apply{
            // 리사이클러뷰 설정
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

            adapter = recyclerAdapter
        }
    }

    override fun onItemClicked() {
        Log.d(TAG, "onItemClicked:- MyViewOlhder -called() ")

    }

}