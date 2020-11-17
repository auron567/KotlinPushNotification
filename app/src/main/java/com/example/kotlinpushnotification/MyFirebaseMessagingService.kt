package com.example.kotlinpushnotification

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import timber.log.Timber

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Timber.d("Refreshed token: $token")
        getSharedPreferences("_", MODE_PRIVATE).edit().putString("fcm_token", token).apply()
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Timber.d("From: ${remoteMessage.from}")
        handleMessage()
    }

    private fun handleMessage() {
        val handler = Handler(Looper.getMainLooper())
        handler.post {
            Toast.makeText(baseContext, getString(R.string.do_something), Toast.LENGTH_LONG).show()
        }
    }
}
