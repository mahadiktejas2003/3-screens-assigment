package com.example.chatwiseassgandroid_shoppingapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // Get the product ID from the Intent
        val productId = intent.getIntExtra("PRODUCT_ID", -1)

        // Fetch product details based on the ID
        // For example purposes, let's just display the ID
        val textView = findViewById<TextView>(R.id.productDetailTextView)
        textView.text = "Product ID: $productId"
    }
}
