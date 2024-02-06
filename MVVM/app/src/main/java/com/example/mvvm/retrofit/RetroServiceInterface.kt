package com.example.mvvm.retrofit

import com.example.mvvm.commom.END_POINT
import com.example.mvvm.data.ResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET(END_POINT)
    fun  getResponse(): Call<List<ResponseItem>>
}