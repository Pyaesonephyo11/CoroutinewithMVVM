package com.example.coroutinewithmvvm.reposity

import com.example.coroutinewithmvvm.service.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllData()=retrofitService.getAllData()
}