package com.locotoDevTeam.diccionariocamba.view.detail

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.locotoDevTeam.diccionariocamba.room.dao.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    val isFavorite = MutableLiveData<Boolean>()

    fun updateFavorites(id: Int, isFavorite: Boolean, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val room = AppDatabase.getInstance(context)
            room.dictionaryDao().updateFavorite(id, isFavorite)
            this@DetailViewModel.isFavorite.postValue(isFavorite)
        }
    }

}