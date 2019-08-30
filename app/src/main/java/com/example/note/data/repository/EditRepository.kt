package com.example.note.data.repository

import android.util.Log
import android.widget.Toast
import com.example.note.contract.EditContract
import com.example.note.data.RetrofitService
import com.example.note.data.model.Note
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditRepository : EditContract.Repository{

    private val URL = "http://10.156.145.148:1234"
    private val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
    private val retrofitService = retrofit.create(RetrofitService::class.java)

    interface NewSaveListener{
        fun onSuccess(note: Note)
        fun onFail()
    }

    interface SaveListener{
        fun onSuccess(note: Note)
        fun onFail()
    }

    interface DeleteListener{
        fun onSuccess()
        fun onFail()
    }

    override fun save(title: String, contents: String, date: String, id: String?, note_id: Int, flag: Boolean,  listener: SaveListener, nListener: NewSaveListener) {
        if(flag){
            val call = retrofitService.addNote(title, contents, date, id)
            call.enqueue(object : Callback<Note>{
                override fun onFailure(call: Call<Note>?, t: Throwable?) {
                    listener.onFail()
                    Log.d("serverDebug", t?.message)
                }

                override fun onResponse(call: Call<Note>?, response: Response<Note>?) {
                    if (response?.code() == 200){
                        nListener.onSuccess(response.body())
                    } else if(response?.code() == 500){
                        nListener.onFail()
                    }
                }
            })
        } else if(!flag){
            val call = retrofitService.modifyNote(title, contents, date, note_id, id)
            call.enqueue(object : Callback<Note>{
                override fun onFailure(call: Call<Note>?, t: Throwable?) {
                    nListener.onFail()
                    Log.d("serverDebug", t?.message)
                }

                override fun onResponse(call: Call<Note>?, response: Response<Note>?) {
                    if (response?.code() == 200){
                        listener.onSuccess(response.body())
                    } else if(response?.code() == 500){
                        listener.onFail()
                    }
                }
            })
        }
    }

    override fun delete(listener: DeleteListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}