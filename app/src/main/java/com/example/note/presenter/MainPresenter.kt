package com.example.note.presenter

import android.content.Context
import com.example.note.contract.MainContract
import com.example.note.data.local.PrefHelper
import com.example.note.data.model.Note
import com.example.note.data.repository.MainRepository
import com.example.note.ui.activity.MainActivity

class MainPresenter (
    private val mainView: MainContract.View,
    private val mainRepository: MainContract.Repository,
    context: Context
): MainContract.Presenter{

    private val prefHelper = PrefHelper.getInstance(context)
    val id = prefHelper?.getId()

    override fun onStarted() {
        mainRepository.getNoteList(id, object : MainRepository.GetNotesListener{
            override fun onSuccess(items: ArrayList<Note>?) {
                mainView.addItems(items)
            }
            override fun onFail(msg: String?) {
                mainView.showMessageForDataLoadingFail(msg)
            }
        })
    }
}