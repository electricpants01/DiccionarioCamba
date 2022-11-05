package com.locotoDevTeam.diccionariocamba.view.slide

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.room.dao.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SlideViewModel: ViewModel() {

    val dictionaryList = MutableLiveData<List<Dictionary>>()

    fun getAllDictionaries(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val room = AppDatabase.getInstance(context)
            dictionaryList.postValue(room.dictionaryDao().getAll())
        }
    }

}