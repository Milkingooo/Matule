package com.example.matule.domain

import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class FirebaseRepository {
    private val auth = FirebaseAuth.getInstance()

    // Метод для авторизации с обработкой исключений
    fun signIn(email: String, password: String, callback: (Boolean) -> Unit) {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    callback(true)
                }
                .addOnFailureListener {
                    callback(false)
                }
        } catch (e: Exception) {
            Log.d("LoginSignIp:", e.message.toString())
            callback(false)
        }
    }

    // Метод для регистрации с обработкой исключений
    fun signUp(email: String, password: String, callback: (Boolean) -> Unit) {
        try {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    callback(true)
                }
                .addOnFailureListener {
                    callback(false)
                }
        } catch (e: Exception) {
            Log.d("LoginSignUp:", e.message.toString())
            callback(false)
        }
    }

    // Метод для отправки ссылки на восстановление пароля с обработкой исключений
    fun sendResetLink(email: String, callback: (Boolean) -> Unit) {
        try {
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener {
                    callback(true)
                }
                .addOnFailureListener {
                    callback(false)
                }
        } catch (e: Exception) {
            Log.d("EmailReset:", e.message.toString())
            callback(false)
        }

    }
}