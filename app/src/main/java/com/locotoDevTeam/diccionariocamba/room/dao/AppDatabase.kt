package com.locotoDevTeam.diccionariocamba.room.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.locotoDevTeam.diccionariocamba.model.Dictionary

@Database(entities = [Dictionary::class], version = 1)
abstract class AppDatabase(): RoomDatabase() {

    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "diccionario-camba.db")
                .build()
        }
    }

    abstract fun dictionaryDao(): DictionaryDao

}