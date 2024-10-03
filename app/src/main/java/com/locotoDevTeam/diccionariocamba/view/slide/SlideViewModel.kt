package com.locotoDevTeam.diccionariocamba.view.slide

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.room.dao.DictionaryDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SlideViewModel @Inject constructor(
    private val dictionaryDao: DictionaryDao,
): ViewModel() {

    val dictionaryList = MutableLiveData<List<Dictionary>>()

    fun getAllDictionaries() {
        CoroutineScope(Dispatchers.IO).launch {
            dictionaryDao.getAll().collectLatest {
                dictionaryList.postValue(it)
            }
        }
    }

}