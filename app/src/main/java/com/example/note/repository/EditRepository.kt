package com.example.note.repository

import com.example.note.contract.EditContract

class EditRepository : EditContract.Repository{

    interface SaveListener{
        fun onSuccess()
        fun onFail()
    }

    interface DeleteListener{
        fun onSuccess()
        fun onFail()
    }

    override fun save(title: String, contents: String, listener: SaveListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(listener: DeleteListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}