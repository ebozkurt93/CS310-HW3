package edu.sabanciuniv.newsstarterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import edu.sabanciuniv.newsstarterapp.model.NewsItem;

public class NewsDetailsActivity extends BaseActivity {

    TextView title, date, text;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(R.string.news_details);

        title = (TextView) findViewById(R.id.news_details_title);
        date = (TextView) findViewById(R.id.news_details_date);
        text = (TextView) findViewById(R.id.news_details_text);
        image = (ImageView) findViewById(R.id.news_details_image);

        String i = String.valueOf(getIntent().getStringExtra("newsimage"));
        Log.i("dev", i);

        title.setText(getIntent().getStringExtra("newstitle"));
        date.setText(getIntent().getStringExtra("newsdate"));
        //getIntent().getIntExtra("newsimage", 0);
        image.setImageResource(getIntent().getIntExtra("newsimage", 0));
        text.setText(getIntent().getStringExtra("newstext"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_news_details_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.news_details_menu_comments:
                //todo add intent here
                Intent i = new Intent(NewsDetailsActivity.this, CommentsActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
