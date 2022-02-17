package com.example.recipe_calculator_api

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view.view.*

class MyViewHolder(itemView: View,
                   recyclerviewInterface: RecyclerviewInterface):
                    RecyclerView.ViewHolder(itemView),
                    View.OnClickListener{
    val TAG: String ="로그"
    
    private val usernameTextView = itemView.user_name
    private val profileImageView = itemView.profile_img

    private var recyclerviewInterface: RecyclerviewInterface ?= null
    //기본 생성자

    init {
        Log.d(TAG, "MyViewholder- init() Called: ")
        itemView.setOnClickListener(this)
        this.recyclerviewInterface = recyclerviewInterface
    }

    fun bind(model : Model){
        Log.d(TAG, "bind: MyViewHolder - bind Called")
        usernameTextView.text =model.name

        Glide
            .with(App.instance)
            .load(model.profileImage)
            .placeholder(R.mipmap.ic_launcher)
            .into(profileImageView)
    }

    override fun onClick(p0: View?) {
        Log.d(TAG, "onClick: Called ( MY ViewHolder)")
        this.recyclerviewInterface?.onItemClicked()
    }
}