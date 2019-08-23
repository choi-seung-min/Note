package com.example.note.presenter

import com.example.note.contract.EditContract
import com.example.note.data.repository.EditRepository
import java.text.SimpleDateFormat
import java.util.*

class EditPresenter (
    private val editView: EditContract.View,
    private val editRepository: EditContract.Repository
) : EditContract.Presenter{

    override fun onClickSave() {
        val title = editView.getNoteTitle()
        val contents = editView.getNoteContent()
        val dateFormat = SimpleDateFormat("yyyy-mm--dd-ss")
        val date = GregorianCalendar(Locale.KOREA)
        date.time = Date()
        val strDate = dateFormat.format(date.time)

        val id = "test"
        //TODO: get user id
        val flag = true
        //TODO: get Flag of new, modify note(true == new)

        editRepository.save(title, contents, strDate, id, flag, object : EditRepository.SaveListener{

            override fun onSuccess() {
                editView.showMessageForNoteSave()
            }

            override fun onFail() {
                editView.showMessageForNoteSave()
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