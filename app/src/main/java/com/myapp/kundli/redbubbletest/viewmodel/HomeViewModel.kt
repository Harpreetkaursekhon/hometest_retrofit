package com.myapp.kundli.retrofitwithkotlincoroutines.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.kundli.redbubbletest.model.Home
import com.myapp.kundli.redbubbletest.network.RetrofitBuilder
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(): ViewModel() {

    val postmutablelivedata: MutableLiveData<Home> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            try {
                  val response= RetrofitBuilder.api.getHome()

                postmutablelivedata.value = response
            }catch (e:Exception){
                Log.d("main","getPost: ${e.message}")
            }
        }
    }
}