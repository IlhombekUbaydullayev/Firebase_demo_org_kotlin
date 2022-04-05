package com.example.firebase_demo_kotlin.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase_demo_kotlin.R
import com.example.firebase_demo_kotlin.activity.MainActivity
import com.example.firebase_demo_kotlin.model.Post

class PostAdapter(var activity: MainActivity, var items: ArrayList<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_post_list, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post: Post = items[position]
        if (holder is PostViewHolder) {
            holder.tv_title.text = post.title!!.toUpperCase()
            holder.tv_body.text = post.body
            holder.delete.setOnClickListener {
                activity.apiDeletePost(post)
                Toast.makeText(this.activity,"OnSuccess delete" + position, Toast.LENGTH_SHORT).show()
                Log.d("this","Ok")
            }
        }
    }

    inner class PostViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tv_title: TextView
        var tv_body: TextView
        var ll_post: RelativeLayout
        var delete: ImageView

        init {
            ll_post = view.findViewById(R.id.view_foreground)
            tv_title = view.findViewById(R.id.tv_title)
            tv_body = view.findViewById(R.id.tv_body)
            delete = view.findViewById(R.id.delete)
        }
    }


    init {
        this.activity = activity
        this.items = items
    }
}