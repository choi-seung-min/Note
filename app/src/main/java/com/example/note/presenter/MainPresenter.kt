package com.example.note.presenter

import com.example.note.contract.MainContract
import com.example.note.data.model.Note
import com.example.note.data.repository.MainRepository
import retrofit2.Call

class MainPresenter (
    private val mainView: MainContract.View,
    private val mainRepository: MainContract.Repository
): MainContract.Presenter{

    val testId = "asd"

    override fun onStarted() {
        mainRepository.getNoteList(testId, object : MainRepository.GetNotesListener{
            override fun onSuccess(call: Call<ArrayList<Note>>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFail() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

    override fun onClickItem() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}