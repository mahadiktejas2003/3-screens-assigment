package com.example.chatwiseassgandroid_shoppingapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    private val TAG = "SecondActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val title: TextView = findViewById(R.id.title)
        title.text = "Products List"

        recyclerView = findViewById(R.id.recyclerView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val responseBody = response.body()
                val productArray = responseBody?.products ?: emptyList()

                myAdapter = MyAdapter(this@SecondActivity, productArray) { product ->
                    onItemClick(product)
                }
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@SecondActivity)
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
            }
        })
    }

    private fun onItemClick(product: Product) {
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra("product", product)
        startActivity(intent)
    }
}
