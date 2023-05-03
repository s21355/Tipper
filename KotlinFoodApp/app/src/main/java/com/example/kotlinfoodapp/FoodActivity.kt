package com.example.kotlinfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class FoodActivity : AppCompatActivity() {
    private lateinit var textMeal: TextView
    private lateinit var textInstructions: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        textMeal = findViewById(R.id.textViewMealName)
        textInstructions = findViewById(R.id.textViewInstructions)

        fetchMealRecipe()
    }

    private fun fetchMealRecipe() {
        val url = "https://www.themealdb.com/api/json/v1/1/random.php"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                try {
                    val meals = response.getJSONArray("meals")
                    val meal = meals.getJSONObject(0)
                    val strMeal = meal.getString("strMeal")
                    val strInstructions = meal.getString("strInstructions")

                    textMeal.text = strMeal
                    textInstructions.text = strInstructions
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, Response.ErrorListener { error ->
                error.printStackTrace()
            })

        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonObjectRequest)
    }

}