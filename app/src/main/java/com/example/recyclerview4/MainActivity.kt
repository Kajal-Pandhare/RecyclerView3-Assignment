package com.example.recyclerview4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerPost: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private val post = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerPost = findViewById(R.id.recyclerView)
        initViews()

        postAdapter = PostAdapter(post)
        postAdapter.onPostClickListener = MyOnClickListener()
        recyclerPost.adapter = postAdapter

        recyclerPost.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                false
            )

    }

    inner class MyOnClickListener : PostAdapter.OnPostClickListener{
        override fun onPostListener(position: Int, post: Post,view: View) {
            Toast.makeText(this@MainActivity,"My action : ${position +1 } is clicked",Toast.LENGTH_SHORT).show()
        }
    }
    private fun initViews(){
        post.add(
            Post("Virat",
                R.drawable.image1,
                "User id - kajal pandhare",
                "Caption - My favorite player ",
                )
        )
        post.add(Post(
            "Deepika",
            R.drawable.image2,
            "User Id - Deepika",
            "Caption - My everyday craving "
        )
        )

        post.add(Post(
            "Pooja",
            R.drawable.image3,
            "User id - pooja pandhare",
            "Amazing Taste"
        ))
    }
}