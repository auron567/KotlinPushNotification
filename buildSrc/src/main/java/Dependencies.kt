object Versions {
    const val appcompat = "1.2.0"
    const val constraintlayout = "2.0.4"
    const val material = "1.2.1"
    const val firebaseMessaging = "21.0.0"
    const val timber = "4.7.1"
}

object BuildVersions {
    const val agp = "4.1.0"
    const val kotlin = "1.4.10"
    const val googleServices = "4.3.4"
}

object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val googleServices = "com.google.gms.google-services"
}

object Libs {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging:${Versions.firebaseMessaging}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}
