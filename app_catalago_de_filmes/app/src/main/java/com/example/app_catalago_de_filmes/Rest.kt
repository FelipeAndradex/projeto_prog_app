package com.example.app_catalago_de_filmes

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    private val client by lazy{
        OkHttpClient
            .Builder()
            .build()
    }
    val api by lazy {
        Retrofit
            .Builder()
            .client(client)
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}