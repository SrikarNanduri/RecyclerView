package com.example.android.recyclerview;

/**
 * Created by srikarn on 14-03-2018.
 */

public class ImageUrl {
    private String android_image_url;
    private String android_text;


    public String getAndroid_version_name() {
        return android_text;
    }

    public void setAndroid_version_name(String android_text) {
        this.android_text = android_text;
    }


    public String getAndroid_image_url() {
        return android_image_url;
    }

    public void setAndroid_image_url(String android_image_url) {
        this.android_image_url = android_image_url;
    }
}
