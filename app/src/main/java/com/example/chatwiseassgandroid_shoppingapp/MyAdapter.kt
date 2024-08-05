package com.example.chatwiseassgandroid_shoppingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(
    private val context: Context,
    private val productList: List<Product>,
    private val onItemClick: (Product) -> Unit // Lambda function for item click
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        Picasso.get().load(currentItem.thumbnail).into(holder.image)

        holder.itemView.setOnClickListener {
            onItemClick(currentItem) // Invoke the click listener
        }
    }

    override fun getItemCount(): Int = productList.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleTextView)
        val description: TextView = itemView.findViewById(R.id.descriptionTextView)
        val image: ShapeableImageView = itemView.findViewById(R.id.thumbnailImageView)
    }
}
