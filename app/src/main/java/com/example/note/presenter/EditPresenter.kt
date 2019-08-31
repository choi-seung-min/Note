package com.example.note.presenter

import com.example.note.contract.EditContract
import com.example.note.data.local.PrefHelper
import com.example.note.data.model.Note
import com.example.note.data.repository.EditRepository
import com.example.note.ui.activity.EditActivity
import com.example.note.ui.activity.MainActivity
import java.text.SimpleDateFormat
import java.util.*
import javax.security.auth.callback.Callback

class EditPresenter (
    private val editView: EditContract.View,
    private val editRepository: EditContract.Repository
) : EditContract.Presenter{

    var flag: Boolean = true
    //Flag of new, modify note(true == new)

    override fun onClickSave(note_id: Int, position: Int) {
        val title = editView.getNoteTitle()
        val contents = editView.getNoteContent()
        val dateFormat = SimpleDateFormat("yyyy-mm-dd-ss")
        val date = GregorianCalendar(Locale.KOREA)
        date.time = Date()
        val strDate = dateFormat.format(date.time)

        val prefHelper = PrefHelper.getInstance(EditActivity())
        val id = prefHelper?.getId()

        editRepository.save(title, contents, strDate, id, note_id, flag, object : EditRepository.SaveListener{

            override fun onSuccess(note: Note) {
                MainActivity.adapter.item?.set(position, note)
                MainActivity.adapter.notifyDataSetChanged()
                editView.showMessageForNoteSave()
                editView.finishActivity()
            }

            override fun onFail() {
                editView.showMessageForNoteSaveFail()
            }
        }, object : EditRepository.NewSaveListener{
            override fun onSuccess(note: Note) {
                MainActivity.adapter.item!!.add(note)
                MainActivity.adapter.notifyItemInserted(MainActivity.adapter.itemCount+1)
                editView.showMessageForNoteSave()
                editView.finishActivity()
            }
            override fun onFail() {
                editView.showMessageForNoteSaveFail()
            }

        })
    }

    override fun onClickDelete(note_id: Int, position: Int) {

        editRepository.delete(note_id, object : EditRepository.DeleteListener{

            override fun onSuccess() {
                MainActivity.adapter.removeAt(position)
                editView.showMessageForNoteDelete()
                editView.finishActivity()
            }

            override fun onFail() {
                editView.showMessageForNoteSaveFail()
            }

        })
    }

}