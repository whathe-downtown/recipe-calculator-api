package com.example.recipe_calculator_api

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe_calculator_api.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

import java.util.ArrayList

class MainActivity : AppCompatActivity(), MyRecyclerviewInterface {

    val TAG: String = "로그"

    // 데이터를 담을 그릇 즉 배열
    var modelList = ArrayList<MyModel>()

    private lateinit var myRecyclerAdapter: MyRecyclerAdapter

    // 뷰가 화면에 그려질때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        Log.d(TAG, "MainActivity - 반복문 돌리기 전 this.modelList.size : ${this.modelList.size}")

        // 10번 반복한다.
        for (i in 1..10){
            val myModel = MyModel(name = "chungkyu $i", email = "dbcjdrb$i@naver.com")
            this.modelList.add(myModel)
        }

        Log.d(TAG, "MainActivity - 반복문 돌린 후 this.modelList.size : ${this.modelList.size}")

        // 어답터 인스턴스 생성
        myRecyclerAdapter = MyRecyclerAdapter(this)

        myRecyclerAdapter.submitList(this.modelList)

        // 리사이클러뷰 설정
        my_recycler_view.apply {

            // 리사이클러뷰 방향 등 설정
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

            // 어답터 장착
            adapter = myRecyclerAdapter
        }

    }

    override fun onItemClicked(position: Int) {
        Log.d(TAG, "MainActivity - onItemClicked() called / position: $position")

        var name: String? = this.modelList[position].name ?: ""
        val title: String = this.modelList[position].email ?: ""


        var intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", name )
        intent.putExtra("title", title)
        startActivity(intent)
//        AlertDialog.Builder(this)
//            .setTitle(title)
//            .setMessage("$title 와 함께하는 빡코딩! :)")
//            .setPositiveButton("오케이") { dialog, id ->
//                Log.d(TAG, "MainActivity - 다이얼로그 확인 버튼 클릭했음")
//            }
//            .show()

    }

}