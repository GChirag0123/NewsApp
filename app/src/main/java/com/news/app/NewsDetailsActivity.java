package com.news.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class NewsDetailsActivity extends AppCompatActivity {

    String title, desc, imageURL, content, url;
    private TextView titleTV, subDescTV, contentTV;
    private ImageView newsIV;
    private Button readNewsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        imageURL = getIntent().getStringExtra("image");
        content = getIntent().getStringExtra("content");
        url = getIntent().getStringExtra("url");

        titleTV = findViewById(R.id.idTVTitle);
        subDescTV = findViewById(R.id.idTVSubDesc);
        contentTV = findViewById(R.id.idTVContent);
        newsIV = findViewById(R.id.idIVNews);
        readNewsBtn = findViewById(R.id.idBtnReadNews);

        try {
            titleTV.setText(title);
            subDescTV.setText(desc);
            contentTV.setText(content);
        }
        catch (Exception e){

            Toast.makeText(NewsDetailsActivity.this, "Exception Found", Toast.LENGTH_SHORT).show();
        }
        Picasso.get().load(imageURL).into(newsIV);
        readNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }
}