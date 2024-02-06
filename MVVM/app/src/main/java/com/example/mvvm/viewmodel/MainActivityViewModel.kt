package com.example.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.commom.TAG
import com.example.mvvm.data.ResponseItem
import com.example.mvvm.retrofit.RetroInstance
import com.example.mvvm.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<ResponseItem>?>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<ResponseItem>?>{
        return liveDataList
    }

    fun makeAPICall(){
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getResponse()
        call.enqueue(object : Callback<List<ResponseItem>> {
            override fun onResponse(
                call: Call<List<ResponseItem>>,
                response: Response<List<ResponseItem>>
            ) {
                if (response.isSuccessful){
                    liveDataList.postValue(response.body())
/*                    response.body()?.let {
                        for (responseResult in it){
                            Log.i(TAG,"onResponse: ${response.body()}")
                        }
                    }*/
                }
            }

            override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                liveDataList.postValue(null)
                Log.i(TAG, "onFailure: ${t.message}")
            }

        })

    }
}