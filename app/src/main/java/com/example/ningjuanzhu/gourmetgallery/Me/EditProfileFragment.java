package com.example.ningjuanzhu.gourmetgallery.Me;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ningjuanzhu.gourmetgallery.R;
import com.example.ningjuanzhu.gourmetgallery.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ningjuanzhu on 4/11/18.
 */

public class EditProfileFragment extends android.support.v4.app.Fragment {
    private ImageView mProfilePhoto;
    private EditText mDisplayName, mUsername, mWebsite, mDescription, mEmail, mPhoneNumber;
    private TextView mChangeProfilePhoto;
//    private CircleImageView mProfilePhoto;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile,container,false);

        //        mProfilePhoto = (CircleImageView) view.findViewById(R.id.profile_photo);
//        mDisplayName = (EditText) view.findViewById(R.id.display_name);
//        mUsername = (EditText) view.findViewById(R.id.username);
//        mWebsite = (EditText) view.findViewById(R.id.website);
//        mDescription = (EditText) view.findViewById(R.id.description);
//        mEmail = (EditText) view.findViewById(R.id.email);
//        mPhoneNumber = (EditText) view.findViewById(R.id.phoneNumber);
//        mChangeProfilePhoto = (TextView) view.findViewById(R.id.changeProfilePhoto);
////        mFirebaseMethods = new FirebaseMethods(getActivity());

        mProfilePhoto = (ImageView)  view.findViewById(R.id.profile_photo);

        initImageLoader();
        setProfileImage();
        return view;
    }
    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }
    private void setProfileImage(){
        String imgURL = "file5.u148.net/2016/12/images/14812753384668S4GWNCTK.jpg";
        UniversalImageLoader.setImage(imgURL,mProfilePhoto,null,"");
    }
}
