package com.example.moviesearchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayMovie extends AppCompatActivity implements View.OnClickListener {
    TextView title,yr,rtg,runTime,genre,imdbRating,link;
    ImageView imageView;
    Button share,back,feedback;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movie);

        //assign contents from xml to java code
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        feedback = findViewById(R.id.feedbackButton);

        back = findViewById(R.id.backButton);
        imageView = findViewById(R.id.imageView);
        title = findViewById(R.id.titleText);
        yr = findViewById(R.id.releaseText);
        rtg = findViewById(R.id.ratingText);
        runTime = findViewById(R.id.rtText);
        genre = findViewById(R.id.genreText);
        share = findViewById(R.id.shareButton);
        imdbRating = findViewById(R.id.webRatingText);
        link = findViewById(R.id.textView12);

        //set onClickListeners for buttons
            //if u click the text, it will take you to website
        link.setOnClickListener(this);
        feedback.setOnClickListener(this);
        share.setOnClickListener(this);
        back.setOnClickListener(this);

        //set contents up from mainActivity
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        yr.setText(intent.getStringExtra("year"));
        rtg.setText(intent.getStringExtra("rated"));
        runTime.setText(intent.getStringExtra("Run Time"));
        genre.setText(intent.getStringExtra("genre"));
        imdbRating.setText(intent.getStringExtra("rating"));
        //build string URL
        link.setText("https://imdb.com/title/" + intent.getStringExtra("imdbID") + "/");

        //load image into imageView
        Picasso.get().load(intent.getStringExtra("poster")).into(imageView);


    }

    @Override
    public void onClick(View v) {
        //go back to mainActivity
        if(v.equals(back))
        {
            startActivity(new Intent(DisplayMovie.this,MainActivity.class));
        }
        //open website when clicked
        else if(v.equals(link))
        {
            Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(link.getText().toString()));
            startActivity(implicit);
        }
        //shares title and link to imdb website
        else if(v.equals(share))
        {
            Intent implicit = new Intent();
            implicit.setAction(Intent.ACTION_SEND);
            implicit.setType("text/plain");
            implicit.putExtra(Intent.EXTRA_TEXT,title.getText().toString() + ": "
                    + link.getText().toString());
            startActivity(Intent.createChooser(implicit,"Share URL using"));
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