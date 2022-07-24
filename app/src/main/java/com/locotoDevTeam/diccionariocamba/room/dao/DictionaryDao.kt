package com.locotoDevTeam.diccionariocamba.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.locotoDevTeam.diccionariocamba.model.Dictionary

@Dao
interface DictionaryDao {

    @Query("SELECT * FROM dictionary")
    fun getAll(): LiveData<List<Dictionary>>

    @Query("SELECT * FROM dictionary WHERE dictionary.word like :word")
    fun getByWords(word: String): LiveData<List<Dictionary>>
}