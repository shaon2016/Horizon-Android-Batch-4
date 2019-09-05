package com.example.androidbatch4day7.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class Food(
    @PrimaryKey(autoGenerate = false) var id:Int,
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "image") var image:String,
    @ColumnInfo(name = "price") var price:Int)