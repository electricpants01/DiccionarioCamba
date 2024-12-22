package com.locotoDevTeam.diccionariocamba.view.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.locotoDevTeam.diccionariocamba.room.dao.DictionaryDao
import com.locotoinnovations.core.model.Dictionary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val dictionaryDao: DictionaryDao,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenUiState())
    val uiState: StateFlow<MainScreenUiState> = _uiState

    private val _searchText: MutableStateFlow<String> = MutableStateFlow("a")

    init {
        // Start collecting search text and trigger the search
        viewModelScope.launch {
            _searchText
                .debounce(300) // Optional: debounce to avoid triggering too many searches in quick succession
                .distinctUntilChanged() // Only trigger when the search text changes
                .collectLatest { word ->
                    searchInDictionary(word)
                }
        }
    }

    // This method will update the searchText
    fun updateSearchText(newSearchText: String) {
        _searchText.value = newSearchText
    }

    private fun searchInDictionary(word: String) {
        _uiState.update { it.copy(isLoading = true) } // Set loading state
        dictionaryDao.search(word)
            .distinctUntilChanged()
            .onEach { dictionaryList ->
                _uiState.update { it.copy(dictionaryList = dictionaryList, isLoading = false) }
            }
            .launchIn(viewModelScope)
    }
}

data class MainScreenUiState(
    val dictionaryList: List<Dictionary> = emptyList(),
    val isLoading: Boolean = true,
)