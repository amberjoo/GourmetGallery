package com.example.ningjuanzhu.gourmetgallery.Home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ningjuanzhu.gourmetgallery.R;
import com.example.ningjuanzhu.gourmetgallery.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private Context mContext = HomeActivity.this;
    private static final int Actitivty_NUM=0;
    DBHandler mydb;
    private ListView List;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mydb = new DBHandler(getApplicationContext());
        final ArrayList<Post> PostList = mydb.getAllPost();
        List = (ListView) findViewById(R.id.photolist);
        HomeAdapter  homeAdapter = new HomeAdapter(this, PostList);
        List.setAdapter(homeAdapter);
        List.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(getApplicationContext(), HomeInfo.class);
                        Post post = (Post) parent.getItemAtPosition(position);
                        i.putExtra("post",post);
                        startActivity(i);
                    }
                });

        setupButtomNavigationView();
    }

    private void setupButtomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewerBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(Actitivty_NUM);
        menuItem.setChecked(true);


    }
}
