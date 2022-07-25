package com.locotoDevTeam.diccionariocamba.view.favorites

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.room.dao.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel: ViewModel() {

    val favoriteList = MutableLiveData<List<Dictionary>>()


    fun getAllFavorites(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            val room = AppDatabase.getInstance(context)
            favoriteList.postValue(room.dictionaryDao().getFavorites())
        }
    }

}