package com.example.androidbatch4day7.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidbatch4day7.R
import com.example.androidbatch4day7.adapter.FoodAdapter
import com.example.androidbatch4day7.data.db.AppDb
import com.example.androidbatch4day7.models.Food
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FoodAdapter
    private lateinit var db: AppDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnStartActivity.setOnClickListener {
            startActivity(Intent(this, ThreadTestActivity::class.java))
        }

        initVar()
        initView()
    }

    private fun initVar() {
        db = AppDb.getInstance(this)

        insertFoodIntoDB()
        adapter = FoodAdapter(this, getItems() as ArrayList<Food>)
    }

    private fun insertFoodIntoDB() {
//        val f1 = Food(1, "Orange", "", 1800)
//        db.foodDao().insert(f1)
//        val f2 = Food(2, "Apple", "", 1200)
//        db.foodDao().insert(f2)
//        val f3 = Food(3, "Banana", "", 2800)
//        db.foodDao().insert(f3)


//        val f1 = Food(1, "Orange", "https://homepages.cae.wisc.edu/~ece533/images/airplane.png", 1800)
//        db.foodDao().insert(f1)
//        val f2 = Food(2, "Apple", "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png", 1200)
//        db.foodDao().insert(f2)
//        val f3 = Food(3, "Banana", "https://homepages.cae.wisc.edu/~ece533/images/baboon.png", 2800)
//        db.foodDao().insert(f3)

        Thread {
            (0 until 10000000).forEach { index ->
                val f = Food(index, "Apple $index", "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png", 1200)
                db.foodDao().insert(f)
                Log.d("DATATAG", "Index: $index")
            }
        }.start()

    }

    private fun getItems() = db.foodDao().all()

    private fun initView() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        rvFoods.adapter = adapter
    }

    override fun onStop() {
        super.onStop()
        Log.d("DATATAG", "Main activity stopped")
    }
}
