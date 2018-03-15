package com.example.android.recyclerview;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.ProgressBar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private ProgressBar mLoadingIndicator;



    private final String android_text[] = {
            "Loading Image 1",
            "Loading Image 2",
            "Loading Image 3",
            "Loading Image 4",
            "Loading Image 5",

    };
    private final String android_image_urls[] = {
            "http://res.cloudinary.com/srikarnanduri/image/upload/v1521016291/toa-heftiba-250951-unsplash_aad8ft.jpg",
            "http://res.cloudinary.com/srikarnanduri/image/upload/v1521016288/marcus-castro-309376-unsplash_l6j0mb.jpg",
            "http://res.cloudinary.com/srikarnanduri/image/upload/v1508565298/jared-brashier-252015_mioi7d.jpg",
            "http://res.cloudinary.com/srikarnanduri/image/upload/v1508564723/radovan-paska-381890_apqpts.jpg",
            "http://res.cloudinary.com/srikarnanduri/image/upload/c_scale,w_686/v1521016302/sticker-mule-189122-unsplash_pxfhze.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        final ArrayList androidVersions = prepareData();
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, androidVersions);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private ArrayList prepareData(){

        ArrayList mList = new ArrayList<>();
        for(int i=0;i<android_text.length;i++){
            ImageUrl androidVersion = new ImageUrl();
            androidVersion.setAndroid_version_name(android_text[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            mList.add(androidVersion);
        }
        return mList;
    }
}
