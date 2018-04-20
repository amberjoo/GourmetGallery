package com.example.ningjuanzhu.gourmetgallery.Me;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ningjuanzhu.gourmetgallery.R;

/**
 * Created by ningjuanzhu on 4/11/18.
 */

public class SignOutFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signout,container,false);
        return view;
    }
}