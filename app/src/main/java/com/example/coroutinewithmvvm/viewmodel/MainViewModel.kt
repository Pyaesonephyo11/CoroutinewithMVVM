package com.example.coroutinewithmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutinewithmvvm.model.JsonData
import com.example.coroutinewithmvvm.reposity.MainRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val dataList= MutableLiveData<List<JsonData>>()
    var job: Job?=null
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception handler: ${throwable.localizedMessage}")
    }
    val loading= MutableLiveData<Boolean>()

    fun getAllData(){
        job= CoroutineScope(Dispatchers.IO + exceptionHandler)
            .launch {
                val response = mainRepository.getAllData()
                withContext(Dispatchers.Main){
                    if(response.isSuccessful){
                        dataList.postValue(response.body())
                        loading.value=false
                    }else{
                        onError("Error : $ {response.message()}")
                    }
                }
            }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}