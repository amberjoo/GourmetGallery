package com.example.ningjuanzhu.gourmetgallery.Home;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ningjuanzhu on 4/11/18.
 */

public class Post implements Parcelable {
    private int _id;
    private String _name;
    private String _time;
    private String _content;

    public Post() {

    }

    public Post(int _id, String _name, String _time, String _content) {
        this._id = _id;
        this._name = _name;
        this._time = _time;
        this._content = _content;
    }

    public Post(String _name, String _time, String _content) {
        this._name = _name;
        this._time = _time;
        this._content = _content;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_time(String _time) {
        this._time = _time;
    }


    public void set_content(String _content) {
        this._content = _content;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public String get_time() {
        return _time;
    }


    public String get_content() {
        return _content;
    }

    public Post(Parcel in) {
        this._id = in.readInt();
        this._name = in.readString();
        this._time = in.readString();
        this._content = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(_id);
        parcel.writeString(_name);
        parcel.writeString(_time);
        parcel.writeString(_content);


    }
    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {

        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}
