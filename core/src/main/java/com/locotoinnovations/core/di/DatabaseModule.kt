package com.locotoDevTeam.diccionariocamba.di

import android.app.Application
import android.content.Context
import com.locotoDevTeam.diccionariocamba.room.dao.AppDatabase
import com.locotoDevTeam.diccionariocamba.room.dao.DictionaryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideDictionaryDao(appDatabase: AppDatabase): DictionaryDao {
        return appDatabase.dictionaryDao()
    }

}