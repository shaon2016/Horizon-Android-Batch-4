package com.example.androidbatch4day7.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id:Int,
    @SerializedName("name")
    var name:String)