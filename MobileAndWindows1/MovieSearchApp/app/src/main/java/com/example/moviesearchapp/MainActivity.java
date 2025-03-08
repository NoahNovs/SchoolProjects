package com.example.moviesearchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText movieSearch;
    Button searchButton,feedback;
    JSONObject movieInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieSearch = findViewById(R.id.movieSearchText);
        searchButton = findViewById(R.id.movieSearchButton);
        searchButton.setOnClickListener(this);

        feedback = findViewById(R.id.feedbackButton);
        feedback.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    public void onClick(View v) {
        //if "enter" is pressed, then open other activity if it has a valid movie
        if(v.equals(searchButton))
        {
            String titleSearch = movieSearch.getText().toString();
            if(titleSearch.contains(" "))
            {
                titleSearch = titleSearch.replace(" ", "_");
            }

            //concatenate url to make search actually function
            MySingleton.getInstance(this).addToRequestQueue(new JsonObjectRequest
                    (Request.Method.GET, "https://www.omdbapi.com/?t="
                            + titleSearch + "&apikey=98ffed17&" , null,
                            new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            movieInfo = response;
                            Log.d("HELLO", movieInfo.toString());
                            try {
                                Log.d("HELLO AGAIN", movieInfo.get("Year").toString());
                                Intent intent = new Intent(MainActivity.this, DisplayMovie.class);
                                intent.putExtra("title",movieInfo.get("Title").toString());
                                intent.putExtra("year",movieInfo.get("Year").toString());
                                intent.putExtra("rated",movieInfo.get("Rated").toString());
                                intent.putExtra("Run Time",movieInfo.get("Runtime").toString());
                                intent.putExtra("genre",movieInfo.get("Genre").toString());
                                intent.putExtra("rating",movieInfo.get("imdbRating").toString());
                                intent.putExtra("poster", movieInfo.get("Poster").toString());
                                intent.putExtra("imdbID",movieInfo.get("imdbID").toString());

                                startActivity(intent);
                            } catch (JSONException e) {
                                Toast.makeText(MainActivity.this,
                                        "Please enter a valid movie",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //Log.d("AWWW", "SOMETHING WENT WRONG" + error.getMessage());
                            Toast.makeText(MainActivity.this,
                                    "Please enter a valid movie",Toast.LENGTH_SHORT).show();
                        }
                    }));


        }
        //opens email to give developer feedback
        else if(v.equals(feedback))
        {
            String[] s = {"nnovales@iu.edu"};
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, s);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            startActivity(intent);
        }

    }

}