package com.example.recipe_calculator_api

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_calculator_api.data.User
import com.example.recipe_calculator_api.databinding.ItemViewBinding
import com.google.android.material.snackbar.Snackbar
import java.util.ArrayList

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private val userList: ArrayList<User> = arrayListOf()

    class MyViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.userEmail.text= user.email
            binding.userName.text = user.name

                itemView.setOnClickListener {
                Snackbar.make(it, "Item $layoutPosition touched!", Snackbar.LENGTH_SHORT).show()


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}
