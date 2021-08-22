package com.example.happybirthdayapp.models.api

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

open class Api(private val context : Context, private var methodType : String, private var endUrl : String) {
    private val queue = Volley.newRequestQueue(context)
    private val startingUrl : String = "localhost:8080/"

    fun makeRequest(){

        // Determine what request type to pass in
        val requestType = when(methodType){
            "GET" -> Request.Method.GET
            "POST" -> Request.Method.POST
            "PUT" -> Request.Method.PUT
            else -> {
                Request.Method.DELETE
            }
        }

        val stringRequest = StringRequest(requestType, (startingUrl + endUrl),
            { response ->
                //console log the response just as proof as concept
                println(response)
            },
            { println("API Request failed")})

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}