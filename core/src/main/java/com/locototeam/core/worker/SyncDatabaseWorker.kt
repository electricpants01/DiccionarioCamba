package com.locototeam.diccionariocamba.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.locototeam.diccionariocamba.room.dao.AppDatabase
import com.locototeam.core.model.Dictionary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SyncDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    companion object {
        private const val TAG = "SyncDatabaseWorker"
        const val KEY_FILENAME = "CAMBA_DATA_FILENAME"
        const val CAMBA_DATA_FILENAME = "camba-data.json"
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val filename = inputData.getString(KEY_FILENAME)
            if (filename != null) {
                applicationContext.assets.open(filename).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val dictionaryType = object : TypeToken<List<Dictionary>>() {}.type
                        val newWordList: List<Dictionary> =
                            Gson().fromJson(jsonReader, dictionaryType)

                        val database = AppDatabase.getInstance(applicationContext)
                        val dao = database.dictionaryDao()

                        // Obtener todos los registros actuales de la base de datos
                        val existingWords = dao.getAll()

                        // Sincronizar: Insertar nuevos y actualizar los existentes

                        newWordList.forEach { newWord ->
                            val existingWord = existingWords.find { it.word == newWord.word }
                            if (existingWord == null) {
                                // Inserta el nuevo dato si no existe
                                dao.insert(newWord)
                            } else if (existingWord.definition != newWord.definition) {
                                // Actualiza si ha cambiado la definición
                                dao.update(newWord)
                            }
                        }


                        Result.success()
                    }
                }
            } else {
                Log.e(TAG, "Error syncing database - no valid filename")
                Result.failure()
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error syncing database", ex)
            Result.failure()
        }
    }
}
