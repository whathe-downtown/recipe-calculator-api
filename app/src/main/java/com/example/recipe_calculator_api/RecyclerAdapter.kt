package com.example.recipe_calculator_api

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(recyclerviewInterface: RecyclerviewInterface): RecyclerView.Adapter<MyViewHolder>() {
    val TAG: String ="로그"
    private  var modelList = ArrayList<Model>()

    private var recyclerviewInterface: RecyclerviewInterface ?= null


    init {
        this.recyclerviewInterface = recyclerviewInterface
    }
    //뷰홀더가 생성 되었을때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false),this.recyclerviewInterface!!)
    }

    // 뷰와 뷰홀더가 묵였을때
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: Called() / postion : $position")
        holder.bind(this.modelList[position])
        //클릭 설정
        holder.itemView.setOnClickListener {
            Toast.makeText(App.instance, "클릭됨 ! ${this.modelList[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    // 목록의 아이템수
    override fun getItemCount(): Int {
        return  this.modelList.size
    }

    fun submitList(modelList: ArrayList<Model>){
        this.modelList = modelList
    }
}