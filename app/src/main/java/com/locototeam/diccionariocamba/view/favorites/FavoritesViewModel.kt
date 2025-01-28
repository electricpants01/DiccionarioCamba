package com.locototeam.diccionariocamba.view.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.locototeam.diccionariocamba.room.dao.DictionaryDao
import com.locototeam.core.model.Dictionary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val dictionaryDao: DictionaryDao,
) : ViewModel() {

    private val _uiState = MutableStateFlow(FavoritesScreenUiState())
    val uiState: Flow<FavoritesScreenUiState> = _uiState

    init {
        getAllFavorites()
    }

    fun getAllFavorites() {
        dictionaryDao.getFavorites()
            .onEach {
                _uiState.value = _uiState.value.copy(favoriteList = it, isLoading = false)
            }
            .launchIn(viewModelScope)
    }
}

data class FavoritesScreenUiState(
    val favoriteList: List<Dictionary> = emptyList(),
    val isLoading: Boolean = true,
)