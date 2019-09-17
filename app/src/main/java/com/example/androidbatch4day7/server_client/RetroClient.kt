package com.example.androidbatch4day7.server_client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClient {

    private var INSTANCE: Retrofit? = null

    fun getInstance(): Retrofit {
        return if (INSTANCE == null) {
            create()
        } else INSTANCE!!
    }

    private fun create(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://shaoniiuc.com/")
            .build()
    }
}