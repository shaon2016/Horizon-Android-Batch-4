package com.example.androidbatch4day7.server_client

import com.example.androidbatch4day7.models.User

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("my_json")
    fun get(): Call<List<User>>
}
