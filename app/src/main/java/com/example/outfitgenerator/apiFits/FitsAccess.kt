package com.example.outfitgenerator.apiFits

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object FitsAccess {
    val fitsService : IFitsService by lazy {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("https://outfitgenerator.azurewebsites.net/")
            .build()

        return@lazy retrofit.create(IFitsService::class.java)
    }
}