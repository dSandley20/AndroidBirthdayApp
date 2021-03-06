package com.example.happybirthdayapp.models.api

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

open class Api(private val context: Context) {
    private val queue = Volley.newRequestQueue(context)
    private val startingUrl: String = "http://10.0.2.2:8080"

    /**
     * Returns the request type -> to be used with the other function in the Api class
     */
    fun getRequestType(methodType: String): Int {
        // Determine what request type to pass in
        val requestType = when (methodType) {
            "GET" -> Request.Method.GET
            "POST" -> Request.Method.POST
            "PUT" -> Request.Method.PUT
            else -> {
                Request.Method.DELETE
            }
        }
        return requestType
    }

    fun getRequest(requestType: Int, endUrl: String) {
        val stringRequest = StringRequest(requestType, (startingUrl + endUrl),
            { response ->
                //console log the response just as proof as concept
                println(response)
            },
            { err -> println(err) })
        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    fun makeRequest(requestType: Int, endUrl: String){

        val requestBody : JSONObject = JSONObject()
        requestBody.put("username", "foo")
        requestBody.put("password", "foo")
        val stringRequest : StringRequest =
            object : StringRequest(requestType, (startingUrl + endUrl),
                Response.Listener { response ->
                    // response
                    var strResp = response.toString()
                    Log.d("API", strResp)
                },
                Response.ErrorListener { error ->
                    Log.d("API", "error => $error")
                }
            )
            {
                override fun getBodyContentType(): String {
                    return "application/json"
                }
                override fun getBody(): ByteArray {
                    //TODO format as JSON -> move to util file so we can just pass in data as needed
                    val params2 = HashMap<String, String>()
                    //TODO don't have this hardcoded
                    params2.put("username","foo" )
                    params2.put("password", "foo")
                    println(params2)
                    return JSONObject(params2 as Map<String, String>).toString().toByteArray()
                }

            }
        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}