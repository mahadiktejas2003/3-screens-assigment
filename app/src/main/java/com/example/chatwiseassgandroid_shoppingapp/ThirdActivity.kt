package com.example.chatwiseassgandroid_shoppingapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val product = intent.getParcelableExtra<Product>("product")

        val imageView: ImageView = findViewById(R.id.productImage)
        val titleView: TextView = findViewById(R.id.productName)
        val descriptionView: TextView = findViewById(R.id.productDescription)

        if (product != null) {
            titleView.text = product.title
            descriptionView.text = product.description
            Picasso.get().load(product.thumbnail).into(imageView)
        }
        // In your Activity or Fragment
        val buyButton: Button = findViewById(R.id.buyButton)
        buyButton.setOnClickListener {
            // No action is performed
        }

    }
}
