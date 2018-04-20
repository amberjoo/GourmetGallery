package com.example.ningjuanzhu.gourmetgallery.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ningjuanzhu.gourmetgallery.R;

/**
 * Created by ningjuanzhu on 4/11/18.
 */

public class HomeInfo extends AppCompatActivity {
    private Context mContext = HomeInfo.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView name = (TextView) findViewById(R.id.username);
        TextView time = (TextView) findViewById(R.id.row_time);
        TextView content = (TextView) findViewById(R.id.row_content);

        Intent intent = getIntent();
        final Post post = (Post)intent.getParcelableExtra("post");
        final int pid = post.get_id();
        DBHandler mydb = new DBHandler(getApplicationContext());
        final Post post_object = mydb.getPost(pid);

        String test = post_object.get_name();
        name.setText("Last Name :   " + post_object.get_name());
        time.setText("First Name :   " + post_object.get_time());
        content.setText("Address :   " + post_object.get_content()+" ,");
    }
}
