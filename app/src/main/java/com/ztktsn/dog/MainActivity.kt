package com.ztktsn.dog

import android.content.Intent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.os.Bundle
import com.ztktsn.dog.adapter.DogAdapter
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ztktsn.dog.api.dogApi

class MainActivity : AppCompatActivity() {
    private lateinit var dogListRecyclerView: RecyclerView
    private lateinit var searchEditText: EditText

    private val adapter = DogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dogListRecyclerView = findViewById(R.id.dogRecycler)
        searchEditText = findViewById(R.id.search_bar)

        dogListRecyclerView.adapter = adapter
        dogListRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)



       searchEditText.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch(v.text.toString())
                true
            } else false
        }
    }
//
//    override fun onDogClick(dog: dog) {
//        val intent = Intent(this, Detailed::class.java)
//        intent.putExtra("dog", dog)
//        startActivity(intent)
//    }
    
    private fun performSearch(query: String) {
        dogApi.api.getDogByName(query).enqueue(object : Callback<List<dog>> {
            override fun onResponse(call: Call<List<dog>>, response: Response<List<dog>>) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                }
            }

            override fun onFailure(call: Call<List<dog>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}


