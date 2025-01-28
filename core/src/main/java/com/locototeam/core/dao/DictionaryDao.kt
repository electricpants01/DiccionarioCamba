package com.locototeam.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.locototeam.core.model.Dictionary
import kotlinx.coroutines.flow.Flow

@Dao
interface DictionaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertAll(dictionaryList: List<Dictionary>)

    @Query("SELECT * FROM dictionary")
    fun getAll(): List<Dictionary>

    @Query("SELECT * FROM dictionary WHERE dictionary.word like '%' || :word || '%'")
    fun search(word: String): Flow<List<Dictionary>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dictionary: Dictionary)

    @Query("SELECT * FROM dictionary WHERE id = :id")
    fun getById(id: Int): Flow<Dictionary>

    @Query("select * from dictionary where isFavorite = 1")
    fun getFavorites(): Flow<List<Dictionary>>

    @Query("update dictionary set isFavorite = :isFavorite where id = :id")
    fun updateFavorite(id: Int, isFavorite: Boolean)

    @Update
    suspend fun update(dictionary: Dictionary)

    @Query("SELECT * FROM dictionary ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomWord(): Dictionary?
}