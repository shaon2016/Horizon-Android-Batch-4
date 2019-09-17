package com.example.androidbatch4day7.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbatch4day7.R
import com.example.androidbatch4day7.models.User

class UserAdapter(val context: Context, val users: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.MyUserVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserVH {
        return MyUserVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_user_row,
                parent, false
            )
        )
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: MyUserVH, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    private fun getItem(position: Int) = users[position]

    class MyUserVH(v: View) : RecyclerView.ViewHolder(v) {
        private val tvName = v.findViewById<TextView>(R.id.tvName)

        fun bind(user: User) {
            tvName.text = user.name
        }
    }
}