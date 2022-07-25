package com.locotoDevTeam.diccionariocamba.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.locotoDevTeam.diccionariocamba.model.Dictionary

@Dao
interface DictionaryDao {

    @Query("SELECT * FROM dictionary")
    fun getAll(): List<Dictionary>

    @Query("SELECT * FROM dictionary WHERE dictionary.word like :word")
    fun search(word: String): List<Dictionary>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dictionary: Dictionary)
}