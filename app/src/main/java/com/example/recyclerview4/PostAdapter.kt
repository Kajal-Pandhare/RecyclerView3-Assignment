package com.example.recyclerview4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val post : ArrayList<Post>)
    : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    interface OnPostClickListener{
        fun onPostListener(position: Int,post: Post,view: View)
    }
    var onPostClickListener : OnPostClickListener? = null

        inner class PostViewHolder(view :View) :RecyclerView.ViewHolder(view){

            val imageView : ImageView
            val txtUserid : TextView
            val txtUsername : TextView
            val txtCaption : TextView


            init {
                imageView = view.findViewById(R.id.imgPost)
                txtUsername = view.findViewById(R.id.txtUserName)
                txtUserid = view.findViewById(R.id.txtUserId)
                txtCaption = view.findViewById(R.id.txtCaption)

                itemView.setOnClickListener {
                    if (onPostClickListener!=null){
                        onPostClickListener!!.onPostListener(
                            adapterPosition,post[adapterPosition],it)
                    }
                }

            }
        }

    override fun getItemCount() = post.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.post_adapter,null)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.imageView.setImageResource(post[position].imageId)
        holder.txtUsername.text = post[position].userName
        holder.txtUserid.text = post[position].userId
        holder.txtCaption.text = post[position].caption
    }
}