package com.locotoDevTeam.diccionariocamba.view.favorites

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.room.dao.AppDatabase
import com.locotoDevTeam.diccionariocamba.room.dao.DictionaryDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val dictionaryDao: DictionaryDao,
): ViewModel() {

    val favoriteList = MutableLiveData<List<Dictionary>>()


    fun getAllFavorites(){
        CoroutineScope(Dispatchers.IO).launch {
            favoriteList.postValue(dictionaryDao.getFavorites())
        }
    }

}