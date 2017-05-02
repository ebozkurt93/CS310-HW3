package edu.sabanciuniv.newsstarterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import edu.sabanciuniv.newsstarterapp.model.NewsItem;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(R.string.news);

        final ListView lstView = (ListView)findViewById(R.id.activity_main_listView);

        NewsAdapter newsAdapter = new NewsAdapter(this, NewsItem.getAllNews());
        lstView.setAdapter(newsAdapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this, NewsDetailsActivity.class);
                i.putExtra("newstitle",((NewsItem) lstView.getAdapter().getItem(position)).getTitle());
                i.putExtra("newsdate",((NewsItem) lstView.getAdapter().getItem(position)).getNewsDate());
                i.putExtra("newsimage",((NewsItem) lstView.getAdapter().getItem(position)).getImageId());
                i.putExtra("newstext",((NewsItem) lstView.getAdapter().getItem(position)).getText());
                startActivity(i);

            }
        });


    }
}
