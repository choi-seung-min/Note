package com.example.note.data.local

import android.content.Context

class PrefHelper(private val context: Context) {

    private val preference = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

    companion object {

        private var INSTANCE: PrefHelper? = null

        fun getInstance(context: Context): PrefHelper? {
            if (INSTANCE == null) {
                INSTANCE = PrefHelper(context)
            }
            return INSTANCE
        }
    }

    fun setId(id: String) {
        preference.edit().putString("USER_ID", id).apply()
    }

    fun getId(): String? {
        return preference.getString("USER_ID", "")
    }

    fun setURL(URL: String){
        preference.edit().putString("URL", URL).apply()
    }

    fun getURL(): String?{
        return preference.getString("URL", "")
    }
    //TODO: URL to local
}