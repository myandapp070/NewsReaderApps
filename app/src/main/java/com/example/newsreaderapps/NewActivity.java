package com.example.newsreaderapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        String urlToImage = getIntent().getStringExtra("URL_TO_IMAGE");
        String title = getIntent().getStringExtra("TITLE");
        String publishedAt = getIntent().getStringExtra("PUBLISHED_AT");
        String description = getIntent().getStringExtra("DESCRIPTION");

        ImageView newsImageView = findViewById(R.id.newss_image);
        TextView newsTitle=findViewById(R.id.newss_title);
        TextView newsPublish=findViewById(R.id.newss_published_at);
        TextView newsDesc=findViewById(R.id.newss_description);

        Glide.with(this).load(urlToImage).into(newsImageView);
        newsTitle.setText(title);
        newsPublish.setText(publishedAt);
        newsDesc.setText(description);
    }
}