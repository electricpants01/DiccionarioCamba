package com.locotoDevTeam.diccionariocamba.view.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.room.dao.DictionaryDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val dictionaryDao: DictionaryDao,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenUiState())
    val uiState: StateFlow<MainScreenUiState> = _uiState

    init {
        println("chris entro al constructor")
        searchInDictionary("")
    }

    // This method will update the searchText and trigger a new search
    fun updateSearchText(newSearchText: String) {
        _uiState.update { it.copy(searchText = newSearchText, isLoading = true) }
        searchInDictionary(newSearchText)
    }

    private fun searchInDictionary(word: String) {
        dictionaryDao.search(word)
            .onEach { dictionaryList ->
                println("chris entro al onEach $word")
                _uiState.update { it.copy(dictionaryList = dictionaryList, isLoading = false) }
            }
            .launchIn(viewModelScope)
    }
}

data class MainScreenUiState(
    val dictionaryList: List<Dictionary> = emptyList(),
    val searchText: String = "",
    val isLoading: Boolean = true,
)