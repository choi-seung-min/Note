package com.example.note.presenter

import com.example.note.contract.MainContract
import com.example.note.data.local.PrefHelper
import com.example.note.data.model.Note
import com.example.note.data.repository.MainRepository
import com.example.note.ui.activity.MainActivity

class MainPresenter (
    private val mainView: MainContract.View,
    private val mainRepository: MainContract.Repository
): MainContract.Presenter{

    val prefHelper = PrefHelper.getInstance(MainActivity())
    val id = prefHelper?.getId()

    override fun onStarted() {
        mainRepository.getNoteList(id, object : MainRepository.GetNotesListener{
            override fun onSuccess(items: ArrayList<Note>?) {
                mainView.addItems(items)
            }
            override fun onFail() {
                mainView.showMessageForDataLoadingFail()
            }
        })
    }
}