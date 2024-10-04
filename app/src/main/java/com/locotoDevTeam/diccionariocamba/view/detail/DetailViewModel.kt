package com.locotoDevTeam.diccionariocamba.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.room.dao.DictionaryDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val dictionaryDao: DictionaryDao,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailScreenUiState())
    val uiState: Flow<DetailScreenUiState> = _uiState

    fun fetchDictionary(id: Int) {
        dictionaryDao.getById(id)
            .onEach { dictionary ->
                _uiState.update { it.copy(dictionary = dictionary) }
            }.launchIn(viewModelScope)
    }

    fun updateFavorites(id: Int, isFavorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            dictionaryDao.updateFavorite(id, isFavorite)
        }
    }
}

data class DetailScreenUiState(
    val dictionary: Dictionary? = null,
)