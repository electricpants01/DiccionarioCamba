package com.locototeam.core.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.locototeam.core.worker.SeedDatabaseWorker
import com.locototeam.core.worker.SyncDatabaseWorker
import com.locototeam.core.model.Dictionary

@Database(entities = [Dictionary::class], version = 1, exportSchema = false)
abstract class AppDatabase() : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "diccionario-camba.db"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
                                .setInputData(workDataOf(SeedDatabaseWorker.KEY_FILENAME to SeedDatabaseWorker.CAMBA_DATA_FILENAME))
                                .build()
                            WorkManager.getInstance(context).enqueue(request)
                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                            // Verificación de datos nuevos en cada inicio
                            val request = OneTimeWorkRequestBuilder<SyncDatabaseWorker>()
                                .setInputData(workDataOf(SyncDatabaseWorker.KEY_FILENAME to SyncDatabaseWorker.CAMBA_DATA_FILENAME))
                                .build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                )
                .build()
        }
    }

    abstract fun dictionaryDao(): DictionaryDao
}