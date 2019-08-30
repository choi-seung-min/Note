package com.example.note.data

import com.example.note.data.model.LoginData
import com.example.note.data.model.Note
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("/note/getNotes")
    fun getNotes(@Query("user_id") user_id: String?): Call<ArrayList<Note>>

    @FormUrlEncoded
    @POST("/note/addNote")
    fun addNote(@Field("title") title: String, @Field("content") content: String,
                @Field("date") date: String, @Field("user_id") user_id: String?): Call<Note>

    @FormUrlEncoded
    @POST("/note/modify/note")
    fun modifyNote(@Field("title") title: String, @Field("content") content: String,
                   @Field("date") date: String, @Field("note_id") note_id: Int, @Field("user_id") user_id: String?): Call<Note>

    @FormUrlEncoded
    @POST("/user/login")
    fun login(@Field("id") id: String, @Field("password") password: String): Call<LoginData>

    @FormUrlEncoded
    @POST("/user/signup")
    fun signUp(@Field("name") name: String, @Field("id") id: String, @Field("password") password: String): Call<Unit>
}