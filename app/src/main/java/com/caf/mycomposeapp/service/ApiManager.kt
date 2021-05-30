package com.caf.mycomposeapp.service

import com.caf.mycomposeapp.model.CryptoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object {
        fun getCryptoList(
            baseUrl: String = "https://raw.githubusercontent.com/",
            responseCallback: (Response<List<CryptoModel>>) -> Unit
        ) {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CryptoAPI::class.java)
            val call = retrofit.getData()
            call.enqueue(object : Callback<List<CryptoModel>> {
                override fun onResponse(
                    call: Call<List<CryptoModel>>,
                    response: Response<List<CryptoModel>>
                ) {
                    responseCallback(response)
                }

                override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                    t.printStackTrace()
                }
            });
        }
    }
}