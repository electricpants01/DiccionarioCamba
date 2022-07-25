package com.locotoDevTeam.diccionariocamba.view.mainFragment

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.room.dao.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragmentViewModel: ViewModel() {

    var dictionaryList = MutableLiveData<List<Dictionary>>()


    fun insertDictionary(dictionaryList: List<Dictionary>, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val room = AppDatabase.getInstance(context)
            for (dictionary in dictionaryList) {
                room.dictionaryDao().insert(dictionary)
            }
        }
    }

    fun getAllDictionaries(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val room = AppDatabase.getInstance(context)
            dictionaryList.postValue(room.dictionaryDao().getAll())
        }
    }

    fun searchInDictionary(word: String, context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            val room = AppDatabase.getInstance(context)
            dictionaryList.postValue(room.dictionaryDao().search(word))
        }
    }

}