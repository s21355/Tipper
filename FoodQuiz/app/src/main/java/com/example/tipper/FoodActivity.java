package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FoodActivity extends AppCompatActivity {

    private TextView textMeal;
    private TextView textInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        textMeal = findViewById(R.id.textViewMealName);
        textInstructions = findViewById(R.id.textViewInstructions);

        fetchMealRecipe();
    }

    private void fetchMealRecipe() {
        String url = "https://www.themealdb.com/api/json/v1/1/random.php";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray meals = response.getJSONArray("meals");
                            JSONObject meal = meals.getJSONObject(0);
                            String strMeal = meal.getString("strMeal");
                            String strInstructions = meal.getString("strInstructions");

                            textMeal.setText(strMeal);
                            textInstructions.setText(strInstructions);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
