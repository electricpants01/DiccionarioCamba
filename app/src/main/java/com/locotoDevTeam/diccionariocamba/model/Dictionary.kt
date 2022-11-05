package com.locotoDevTeam.diccionariocamba.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dictionary")
data class Dictionary(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val word: String,
    val definition: String,
    var isFavorite: Boolean = false) {
}