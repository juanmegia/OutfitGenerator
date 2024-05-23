package com.example.outfitgenerator.apiFits

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object FitsAccess {
    val fitsService : FitsService by lazy {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("http://127.0.0.1:8000/")
            .build()

        return@lazy retrofit.create(fitsService::class.java)
    }
}