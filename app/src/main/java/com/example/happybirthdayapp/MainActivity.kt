package com.example.happybirthdayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthdayapp.models.adapter.ItemAdapter
import com.example.happybirthdayapp.models.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val affirmationDataSet = Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, affirmationDataSet)
        recyclerView.setHasFixedSize(true)
    }
}