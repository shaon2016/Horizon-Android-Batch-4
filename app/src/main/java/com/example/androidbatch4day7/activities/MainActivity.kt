package com.example.androidbatch4day7.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidbatch4day7.R
import com.example.androidbatch4day7.adapter.FoodAdapter
import com.example.androidbatch4day7.adapter.UserAdapter
import com.example.androidbatch4day7.data.db.AppDb
import com.example.androidbatch4day7.models.Food
import com.example.androidbatch4day7.models.User
import com.example.androidbatch4day7.server_client.APIService
import com.example.androidbatch4day7.server_client.RetroClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FoodAdapter
    private lateinit var db: AppDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        btnStartActivity.setOnClickListener {
//            startActivity(Intent(this, ThreadTestActivity::class.java))
//        }
//
//        initVar()
//        initView()


        getuser()
    }

    private fun getuser() {
        val apiService = RetroClient.getInstance().create(APIService::class.java)

        apiService.get().enqueue(object : Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = response.body() as ArrayList<User>


                    rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
                    val adapter = UserAdapter(this@MainActivity, users)
                    rvUsers.adapter = adapter
                }
            }
        })
    }


   /* private fun initVar() {
        db = AppDb.getInstance(this)

       // insertFoodIntoDB()
        adapter = FoodAdapter(this, getItems() as ArrayList<Food>)
    }

    @SuppressLint("CheckResult")
    private fun insertFoodIntoDB() {
        Observable.fromCallable {
            val f1 = Food(1, "Orange", "https://homepages.cae.wisc.edu/~ece533/images/airplane.png", 1800)
            db.foodDao().insert(f1)
            val f2 = Food(2, "Apple", "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png", 1200)
            db.foodDao().insert(f2)
            val f3 = Food(3, "Banana", "https://homepages.cae.wisc.edu/~ece533/images/baboon.png", 2800)
            db.foodDao().insert(f3)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("DATATAG", "Data inserted successfully")
            }

    }

    private fun getItems() = db.foodDao().all()

    private fun initView() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        rvFoods.adapter = adapter
    }*/
}
