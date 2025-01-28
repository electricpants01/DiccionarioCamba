package com.locototeam.diccionariocamba.view.slide

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.locototeam.diccionariocamba.room.dao.DictionaryDao
import com.locototeam.core.model.Dictionary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SlideViewModel @Inject constructor(
    private val dictionaryDao: DictionaryDao,
) : ViewModel() {
    val dictionaryList = MutableLiveData<List<Dictionary>>()

    fun getAllDictionaries() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = dictionaryDao.getAll()
            dictionaryList.postValue(result)
        }
    }

}