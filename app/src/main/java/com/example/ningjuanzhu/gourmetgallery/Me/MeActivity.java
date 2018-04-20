package com.example.ningjuanzhu.gourmetgallery.Me;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.*;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.ningjuanzhu.gourmetgallery.R;
import com.example.ningjuanzhu.gourmetgallery.Utils.BottomNavigationViewHelper;
import com.google.android.gms.common.util.ArrayUtils;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ningjuanzhu on 4/11/18.
 */

public class MeActivity extends AppCompatActivity {
    private Context mContext = MeActivity.this;
    private static final int Actitivty_NUM=2;
    private ProgressBar mProgressBar;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private TextView mtextEditProfile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);


        setupProfile();
        setupButtomNavigationView();
        setupToolbar();
    }
    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView = findViewById(R.id.gridView);

    }
    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView meMenu = (ImageView) findViewById(R.id.profileMenu);
        meMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("a","ok");
                Intent intent = new Intent(mContext,AccountSettingActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setupProfile(){
        mtextEditProfile = (TextView) findViewById(R.id.textEditProfile);

        mtextEditProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            Toast.makeText(MeActivity.this,"text",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Bitmap image2 = ImageCrop(imageBitmap,false);
            ImageView imageview= findViewById(R.id.profile_photo);
            imageview.setImageBitmap(image2);

            //the following code will save the image
            File storageLoc = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES); //context.getExternalFilesDir(null);

            File file = new File(storageLoc,  "myImage.jpg");

            try{
                FileOutputStream fos = new FileOutputStream(file);
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.close();

                scanFile(this, Uri.fromFile(file));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }public static Bitmap ImageCrop(Bitmap bitmap, boolean isRecycled)
    {

        if (bitmap == null)
        {
            return null;
        }

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        int wh = w > h ? h : w;

        int retX = w > h ? (w - h) / 2 : 0;
        int retY = w > h ? 0 : (h - w) / 2;

        Bitmap bmp = Bitmap.createBitmap(bitmap, retX, retY, wh, wh, null,
                false);
        if (isRecycled && bitmap != null && !bitmap.equals(bmp)
                && !bitmap.isRecycled())
        {
            bitmap.recycle();
            bitmap = null;
        }

        return bmp;
    }

    private static void scanFile(Context context, Uri imageUri){
        Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        scanIntent.setData(imageUri);
        context.sendBroadcast(scanIntent);

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
