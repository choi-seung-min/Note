package com.example.note.data.repository

import com.example.note.contract.SignupContract
import com.example.note.data.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignupRepository : SignupContract.Repository{

    private val URL = "http://10.156.145.148:1234"

    interface SignupListener{
        fun onSuccess()
        fun onFail(t: Throwable?)
    }

    override fun Signup(name: String, id: String, password: String, listener: SignupListener) {
        val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitService = retrofit.create(RetrofitService::class.java)
        val call = retrofitService.signUp(name, id, password)
        call.enqueue(object : Callback<Unit>{
            override fun onFailure(call: Call<Unit>?, t: Throwable?) {
                listener.onFail(t)
            }

            override fun onResponse(call: Call<Unit>?, response: Response<Unit>?) {
                if(response?.code() == 200){
                    listener.onSuccess()
                } else if(response?.code() == 409){
                    listener.onFail(null)
                }
            }
        })
    }
}