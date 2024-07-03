package com.locotoDevTeam.diccionariocamba.di

import android.content.Context
import com.locotoDevTeam.diccionariocamba.room.dao.AppDatabase
import com.locotoDevTeam.diccionariocamba.room.dao.DictionaryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideDictionaryDao(appDatabase: AppDatabase): DictionaryDao {
        return appDatabase.dictionaryDao()
    }

}