package com.example.androidbatch4day7.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidbatch4day7.R
import com.example.androidbatch4day7.adapter.FoodAdapter
import com.example.androidbatch4day7.models.Food
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVar()
        initView()
    }

    private fun initVar() {
        adapter = FoodAdapter(this, getItems())
    }

    private fun getItems(): ArrayList<Food> {
        val f1 = Food(1, "Orange", "", 1800)
        val f2 = Food(2, "Apple", "", 1200)
        val f3 = Food(3, "Banana", "", 2800)

        val items = ArrayList<Food>()
        items.add(f1)
        items.add(f2)
        items.add(f3)

        return items
    }

    private fun initView() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        rvFoods.adapter = adapter
    }


}
