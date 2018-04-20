package com.example.ningjuanzhu.gourmetgallery.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.ningjuanzhu.gourmetgallery.Map.MapActivity;
import com.example.ningjuanzhu.gourmetgallery.Home.HomeActivity;
import com.example.ningjuanzhu.gourmetgallery.Me.MeActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.example.ningjuanzhu.gourmetgallery.R;
/**
 * Created by ningjuanzhu on 4/11/18.
 */

public class BottomNavigationViewHelper {
    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }
    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, HomeActivity.class); //ACTIVITY_NUM = 0
                        context.startActivity(intent1);
                        break;
                    case R.id.ic_add:
                        Intent intent2 = new Intent(context, MapActivity.class);  //ACTIVITY_NUM = 1
                        context.startActivity(intent2);
                        break;
                    case R.id.ic_me:
                        Intent intent3 = new Intent(context, MeActivity.class);   //ACTIVITY_NUM = 2
                        context.startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
}
