package com.example.retrofitroom;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofitroom.model.NewsHeadline;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailActivity extends AppCompatActivity {

    NewsHeadline headline;
    TextView text_title, text_published, text_source, text_data;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        headline = (NewsHeadline) getIntent().getSerializableExtra("data");

        text_data = findViewById(R.id.text_desc_full);
        text_published = findViewById(R.id.text_desc_published);
        text_source = findViewById(R.id.text_desc_source);
        text_title = findViewById(R.id.text_desc_title);
        img_news = findViewById(R.id.img_news);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        Date date = null;//You will get date object relative to server/client timezone wherever it is parsed
        try {
            date = dateFormat.parse(headline.getPublishedAt());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //If you need time just put specific format for time like 'HH:mm:ss'
        String dateStr = formatter.format(date);

        text_title.setText(headline.getTitle());
        text_source.setText(headline.getAuthor());
        text_published.setText(dateStr);
        text_data.setText(headline.getContent());


        Picasso.get().load(headline.getUrlToImage()).into(img_news);


    }
}