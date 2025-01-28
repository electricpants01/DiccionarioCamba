package com.locototeam.diccionariocamba.broadcast

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.locototeam.diccionariocamba.R
import com.locototeam.core.dao.DictionaryDao
import com.locototeam.core.model.Dictionary
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AlarmReceiver : BroadcastReceiver() {

    // Inyectamos el DictionaryDao con Dagger Hilt
    @Inject
    lateinit var dictionaryDao: DictionaryDao

    override fun onReceive(context: Context, intent: Intent?) {
        // Lanza una coroutine para obtener una palabra aleatoria y mostrar una notificación
        retrieveRandomWordAndSendNotification(context)
    }

    private fun retrieveRandomWordAndSendNotification(context: Context) {
        // Usamos una CoroutineScope para operar en el hilo IO y obtener los datos
        val job = CoroutineScope(Dispatchers.IO).launch {
            // Obtener una palabra aleatoria desde la base de datos
            val randomWord = dictionaryDao.getRandomWord()

            // Construir el contenido de la notificación
            val notificationContent = buildNotificationContent(randomWord)

            // Enviar la notificación
            sendNotification(context, notificationContent)
        }

        job.invokeOnCompletion { throwable ->
            throwable?.let {
                // Manejar errores si es necesario
                Log.e("AlarmReceiver", "Error retrieving random word: ${it.message}")
            }
        }
    }

    private fun buildNotificationContent(dictionary: Dictionary?): String {
        return if (dictionary != null) {
            // Formatear el contenido de la notificación con la palabra y su definición
            "Palabra: ${dictionary.word}\nDefinición: ${dictionary.definition}"
        } else {
            "No se encontró ninguna palabra en el diccionario."
        }
    }

    private fun sendNotification(context: Context, content: String) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "daily_notification_channel"
        val channelName = "Notificación diaria de diccionario"

        // Crear un canal de notificación para Android O y superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.diccionario_camba)
            .setContentTitle("Palabra del día")
            .setContentText(content)
            .setStyle(
                NotificationCompat.BigTextStyle().bigText(content)
            ) // Para manejar texto largo
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(0, notification)
    }
}
