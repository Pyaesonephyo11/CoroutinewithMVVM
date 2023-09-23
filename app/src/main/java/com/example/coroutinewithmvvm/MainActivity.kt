package com.example.coroutinewithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coroutinewithmvvm.adapter.RecyclerAdapter
import com.example.coroutinewithmvvm.databinding.ActivityMainBinding
import com.example.coroutinewithmvvm.factory.MyViewModelFactory
import com.example.coroutinewithmvvm.reposity.MainRepository
import com.example.coroutinewithmvvm.service.RetrofitService
import com.example.coroutinewithmvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private val adapter: RecyclerAdapter = RecyclerAdapter()
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService= RetrofitService.getInstance()
        val mainRepository= MainRepository(retrofitService)

        binding.recyclerview.adapter=adapter
        viewModel= ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)


        //  viewModel.dataList.observe(this,{adapter.setData(it)})
        viewModel.dataList.observe(this, {
            adapter.setData(it) })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show() })

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        viewModel.getAllData()
    }
}