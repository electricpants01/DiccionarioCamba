package com.locototeam.diccionariocamba.view.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locototeam.core.model.Dictionary

@Composable
fun MainScreen(
    dictionaryList: List<Dictionary>,
    onSearchQueryChange: (String) -> Unit,
    onItemClick: (Dictionary) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                onSearchQueryChange(it)
            },
            label = { Text("Search...") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(dictionaryList) { item ->
                DictionaryItem(item = item) {
                    onItemClick(item)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryItem(item: Dictionary, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        onClick = onItemClick
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = item.word, style = MaterialTheme.typography.headlineSmall)
            Text(text = item.meaning, style = MaterialTheme.typography.bodyMedium)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    val sampleList = listOf(
        Dictionary(id = 1, word = "Achachay", meaning = "¡Qué frío! Expresión utilizada para denotar una baja temperatura.", favorite = false),
        Dictionary(id = 2, word = "Aillu", meaning = "Familia, comunidad.", favorite = true),
        Dictionary(id = 3, word = "Buri", meaning = "Fiesta, celebración.", favorite = false),
        Dictionary(id = 4, word = "Cambinga", meaning = "Persona de origen camba, diminutivo cariñoso.", favorite = false),
    )
    MainScreen(dictionaryList = sampleList, onSearchQueryChange = {}, onItemClick = {})
}