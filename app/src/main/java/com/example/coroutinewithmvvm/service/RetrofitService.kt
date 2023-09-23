package com.example.coroutinewithmvvm.service

import com.example.coroutinewithmvvm.model.JsonData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    //https://jsonplaceholder.typicode.com/photos
    @GET("photos")
    suspend fun getAllData(): Response<List<JsonData>>

    companion object{
        var retrofitService:RetrofitService?=null
        fun getInstance():RetrofitService{
            if (retrofitService==null){
                val retrofit= Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService=retrofit.create(RetrofitService::class.java)
            }
            return  retrofitService!!;
        }
    }

}