package com.example.kotlinpushnotification

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import timber.log.Timber

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private lateinit var broadcaster: LocalBroadcastManager

    override fun onCreate() {
        super.onCreate()
        broadcaster = LocalBroadcastManager.getInstance(this)
    }

    override fun onNewToken(token: String) {
        Timber.d("Refreshed token: $token")
        getSharedPreferences("_", MODE_PRIVATE).edit().putString("fcm_token", token).apply()
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Timber.d("From: ${remoteMessage.from}")
        handleMessage(remoteMessage)
    }

    private fun handleMessage(remoteMessage: RemoteMessage) {
        val handler = Handler(Looper.getMainLooper())
        handler.post {
            Toast.makeText(baseContext, getString(R.string.do_something), Toast.LENGTH_LONG).show()

            // Send broadcast
            remoteMessage.notification?.let {
                val intent = Intent("MyData")
                intent.putExtra("message", remoteMessage.data["text"])
                broadcaster.sendBroadcast(intent)
            }
        }
    }
}
