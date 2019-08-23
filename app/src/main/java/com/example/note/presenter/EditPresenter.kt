package com.example.note.presenter

import com.example.note.contract.EditContract
import com.example.note.data.repository.EditRepository

class EditPresenter (
    private val editView: EditContract.View,
    private val editRepository: EditContract.Repository
) : EditContract.Presenter{

    override fun onClickSave() {
        val title = "0"
        val contents = "0"
        editRepository.save(title, contents, object : EditRepository.SaveListener{

            override fun onSuccess() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFail() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    override fun onClickDelete() {
        editRepository.delete(object : EditRepository.DeleteListener{

            override fun onSuccess() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFail() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

}