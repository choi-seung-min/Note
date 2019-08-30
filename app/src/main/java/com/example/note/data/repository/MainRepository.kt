package com.example.note.data.repository

import com.example.note.contract.MainContract
import com.example.note.data.RetrofitService
import com.example.note.data.model.Note
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository: MainContract.Repository{


    private val URL = "http://10.156.145.148:1234"

    interface GetNotesListener{
        fun onSuccess(items: ArrayList<Note>?)
        fun onFail()
    }

    override fun getNoteList(id: String?, listener: GetNotesListener) {
        val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitService = retrofit.create(RetrofitService::class.java)
        val call = retrofitService.getNotes(id)
        call.enqueue(object : Callback<ArrayList<Note>>{
            override fun onFailure(call: Call<ArrayList<Note>>?, t: Throwable?) {
                listener.onFail()
            }

            override fun onResponse(call: Call<ArrayList<Note>>?, response: Response<ArrayList<Note>>?) {
                if (response?.code() == 200){
                    listener.onSuccess(response.body())
                } else if(response?.code() == 500){
                    listener.onFail()
                }
            }
        })
    }
}