package com.example.firebase_demo_kotlin.manager

import java.lang.Exception

interface AuthHandler {
    fun onSuccess()
    fun onError(exception: Exception?)
}