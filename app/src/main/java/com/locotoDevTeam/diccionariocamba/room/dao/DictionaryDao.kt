package com.locotoDevTeam.diccionariocamba.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.locotoDevTeam.diccionariocamba.model.Dictionary

@Dao
interface DictionaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertAll(dictionaryList: List<Dictionary>)

    @Query("SELECT * FROM dictionary")
    fun getAll(): List<Dictionary>

    @Query("SELECT * FROM dictionary WHERE dictionary.word like '%' || :word || '%'")
    fun search(word: String): List<Dictionary>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dictionary: Dictionary)

    @Query("select * from dictionary where isFavorite = 1")
    fun getFavorites(): List<Dictionary>

    @Query("update dictionary set isFavorite = :isFavorite where id = :id")
    fun updateFavorite(id: Int, isFavorite: Boolean)
}