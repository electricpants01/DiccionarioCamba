package com.locotoDevTeam.diccionariocamba.model

import androidx.room.Entity

@Entity(tableName = "dictionary", primaryKeys = ["id"])
data class Dictionary(
    val id: Int,
    val word: String,
    val definition: String) {
}