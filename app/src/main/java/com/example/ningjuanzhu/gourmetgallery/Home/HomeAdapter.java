package com.example.ningjuanzhu.gourmetgallery.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import com.example.ningjuanzhu.gourmetgallery.R;

import java.util.ArrayList;

/**
 * Created by ningjuanzhu on 4/11/18.
 */

public class HomeAdapter extends ArrayAdapter<Post>{
    public HomeAdapter(Context context, ArrayList<Post> postlist) {
        super(context,R.layout.layout_row, postlist);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = LayoutInflater.from(getContext()).inflate(R.layout.layout_row,parent,false);

        Post post = getItem(position);
        TextView name = (TextView)customView.findViewById(R.id.username);
        TextView time = (TextView)customView.findViewById(R.id.row_time);
        ImageView Image = (ImageView)customView.findViewById(R.id.post_image);

        name.setText(post.get_name());
        time.setText(post.get_time());
        Image.setImageResource(R.drawable.food);
        return customView;

    }
}
