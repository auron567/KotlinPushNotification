package com.example.kotlinpushnotification

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinpushnotification.databinding.ActivityMainBinding
import com.google.firebase.installations.FirebaseInstallations
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.retrieveTokenButton.setOnClickListener {
            // Get device token
            FirebaseInstallations.getInstance().getToken(false)
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Timber.w(task.exception)
                        return@addOnCompleteListener
                    }

                    val token = task.result?.token
                    Timber.d("Token: $token")
                    Toast.makeText(this, "Token: $token", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
