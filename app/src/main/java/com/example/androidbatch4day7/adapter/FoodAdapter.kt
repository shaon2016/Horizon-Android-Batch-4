package com.example.androidbatch4day7.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidbatch4day7.R
import com.example.androidbatch4day7.data.db.AppDb
import com.example.androidbatch4day7.models.Food

class FoodAdapter(val context:Context, val items:ArrayList<Food>)  :
    RecyclerView.Adapter<FoodAdapter.MyFoodVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFoodVH {
        return MyFoodVH(LayoutInflater.from(parent.context).inflate(R.layout.rv_home_food_list_row,
            parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MyFoodVH, position: Int) {
        holder.bind(getItem(position))
    }

    fun getItem(pos:Int) = items[pos]


    inner class MyFoodVH(v:View) :RecyclerView.ViewHolder(v) {
       private val ivFood = v.findViewById<ImageView>(R.id.ivFood)
       private val tvName = v.findViewById<TextView>(R.id.tvName)
       private val tvPrice = v.findViewById<TextView>(R.id.tvPrice)

        fun bind(f: Food) {
            tvName.text = f.name
            tvPrice.text = f.price.toString()

            Glide.with(context)
                .load(f.image)
                .into(ivFood)

            itemView.setOnClickListener {
                val db = AppDb.getInstance(context)
                db.foodDao().delete(f)
                items.remove(f)
                notifyDataSetChanged()
            }
        }

    }
}