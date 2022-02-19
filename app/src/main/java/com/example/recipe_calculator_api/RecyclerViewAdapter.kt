package com.example.recipe_calculator_api

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_calculator_api.data.User
import com.example.recipe_calculator_api.databinding.ItemViewBinding

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    var userList = mutableListOf<User>()

    inner class MyViewHolder(private  val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User){

            binding.userName.text= user.name
            binding.userEmail.text= user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=  ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(binding).apply {
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val user: User =userList.get(curPos)
                Toast.makeText(parent.context, "이름: ${user.name} 이메일 ${user.email}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            intent.putExtra(userList[position].name, userList[position].email)
            ContextCompat.startActivity(holder.itemView.context, intent, null)


        }

    }

    override fun getItemCount(): Int=userList.size
    fun submitList(userList: ArrayList<User>){
        this.userList = userList
    }
}