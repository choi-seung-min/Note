package com.example.note.data.repository

import com.example.note.contract.EditContract
import com.example.note.data.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditRepository : EditContract.Repository{

    private val URL = "http://10.156.145.148:1234"
    private val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
    private val retrofitService = retrofit.create(RetrofitService::class.java)

    interface SaveListener{
        fun onSuccess()
        fun onFail()
    }

    interface DeleteListener{
        fun onSuccess()
        fun onFail()
    }

    override fun save(title: String, contents: String, date: String, id: String, note_id: String, flag: Boolean,  listener: SaveListener) {
        if(flag){
            val call = retrofitService.addNote(title, contents, date, id)
            call.enqueue(object : Callback<Unit>{
                override fun onFailure(call: Call<Unit>?, t: Throwable?) {
                    listener.onFail()
                }

                override fun onResponse(call: Call<Unit>?, response: Response<Unit>?) {
                    listener.onSuccess()
                }
            })
        } else if(!flag){
            val call = retrofitService.modifyNote(title, contents, date,note_id, id)
            call.enqueue(object : Callback<Unit>{
                override fun onFailure(call: Call<Unit>?, t: Throwable?) {
                    listener.onFail()
                }

                override fun onResponse(call: Call<Unit>?, response: Response<Unit>?) {
                    listener.onSuccess()
                }
            })
        }
    }

    override fun delete(listener: DeleteListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}