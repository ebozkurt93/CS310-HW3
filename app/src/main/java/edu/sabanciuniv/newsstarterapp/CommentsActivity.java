package edu.sabanciuniv.newsstarterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import edu.sabanciuniv.newsstarterapp.model.CommentItem;
import edu.sabanciuniv.newsstarterapp.model.NewsItem;

public class CommentsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(R.string.comments);

        final ListView lstView = (ListView) findViewById(R.id.comments_listView);

        CommentsAdapter commentsAdapter = new CommentsAdapter(this, NewsItem.getComments());
        lstView.setAdapter(commentsAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_comments_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.activity_comments_menu_addComment:
                Intent i = new Intent(CommentsActivity.this, PostCommentActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
