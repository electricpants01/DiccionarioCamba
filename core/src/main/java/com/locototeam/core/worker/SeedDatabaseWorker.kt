package com.locototeam.core.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.locototeam.core.dao.AppDatabase
import com.locototeam.core.model.Dictionary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters,
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val filename = inputData.getString(KEY_FILENAME)
            if (filename != null) {
                applicationContext.assets.open(filename).use { inputStream ->
                    com.google.gson.stream.JsonReader(inputStream.reader()).use { jsonReader ->
                        val dictionaryType = object : TypeToken<List<Dictionary>>() {}.type
                        val dictionaryList: List<Dictionary> =
                            Gson().fromJson(jsonReader, dictionaryType)

                        val database = AppDatabase.getInstance(applicationContext)
                        database.dictionaryDao().upsertAll(dictionaryList)

                        Result.success()
                    }
                }
            } else {
                Log.e(TAG, "Error seeding database - no valid filename")
                Result.failure()
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
        const val KEY_FILENAME = "CAMBA_DATA_FILENAME"
        const val CAMBA_DATA_FILENAME = "camba-data.json"
    }
}