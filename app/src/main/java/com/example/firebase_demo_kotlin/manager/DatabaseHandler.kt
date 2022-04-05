package com.example.firebase_demo_kotlin.manager

import com.example.firebase_demo_kotlin.model.Post


interface DatabaseHandler {
    fun onSuccess(post: Post? = null, posts: ArrayList<Post> = ArrayList())
    fun onError()
}