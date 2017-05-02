package edu.sabanciuniv.newsstarterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PostCommentActivity extends BaseActivity {

    EditText name, message;
    Button postCommentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_comment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(R.string.post_comment);

        name = (EditText) findViewById(R.id.post_comment_name);
        message = (EditText) findViewById(R.id.post_comment_message);
        postCommentButton = (Button) findViewById(R.id.post_comment_postButton);

        postCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PostCommentActivity.this, "name: " + name.getText().toString() + "\nmessage: " + message.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
