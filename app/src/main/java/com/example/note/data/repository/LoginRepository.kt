package com.example.note.data.repository

import com.example.note.contract.LoginContract
import com.example.note.data.RetrofitService
import com.example.note.data.model.LoginData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginRepository : LoginContract.Repository{

    private val URL = "http://10.156.145.148:1234"

    interface LoginListener{
        fun onSuccess()
        fun onFail(msg: String?)
    }

    override fun logIn(id: String, password: String, listener: LoginListener) {
        val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitService = retrofit.create(RetrofitService::class.java)
        val call = retrofitService.login(id, password)
        call.enqueue(object : Callback<LoginData>{
            override fun onFailure(call: Call<LoginData>?, t: Throwable?) {
                listener.onFail(t?.message)
            }

            override fun onResponse(call: Call<LoginData>?, response: Response<LoginData>?) {
                if (response?.code() == 200){
                    listener.onSuccess()
                } else if(response?.code() == 404){
                    listener.onFail("account not exist")
                } else if(response?.code() == 500){
                    listener.onFail("server error")
                }
            }
        })
    }
}