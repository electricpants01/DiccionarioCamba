package com.locotoDevTeam.diccionariocamba.view.detail

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.locotoDevTeam.diccionariocamba.room.dao.AppDatabase
import com.locotoDevTeam.diccionariocamba.room.dao.DictionaryDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val dictionaryDao: DictionaryDao,
): ViewModel() {

    val isFavorite = MutableLiveData<Boolean>()

    fun updateFavorites(id: Int, isFavorite: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            dictionaryDao.updateFavorite(id, isFavorite)
            this@DetailViewModel.isFavorite.postValue(isFavorite)
        }
    }

}