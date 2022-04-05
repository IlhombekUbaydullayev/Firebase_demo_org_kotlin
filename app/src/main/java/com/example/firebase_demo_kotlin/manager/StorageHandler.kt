package com.example.firebase_demo_kotlin.manager

interface StorageHandler {
    fun onSuccess(imgUrl: String)
    fun onError(exception: Exception?)
}