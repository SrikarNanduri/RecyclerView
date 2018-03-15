package com.example.android.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity  {

   /* private LinkedList<String> mWordList = new LinkedList<String>();*/
    private int mCount = 0;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private ProgressBar mLoadingIndicator;



    private final String android_version_names[] = {
            "Loading Image1",
            "Loading Image2",
            "Loading Image3",

    };
    private final String android_image_urls[] = {
            "http://res.cloudinary.com/srikarnanduri/image/upload/v1521016291/toa-heftiba-250951-unsplash_aad8ft.jpg",
            "http://res.cloudinary.com/srikarnanduri/image/upload/v1521016288/marcus-castro-309376-unsplash_l6j0mb.jpg",
            "http://res.cloudinary.com/srikarnanduri/image/upload/v1508565298/jared-brashier-252015_mioi7d.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        /*for(int i =0; i<20; i++){
            mWordList.addLast("ImageRepeats " + mCount++  + "  number of times");
            Log.d("WordList", mWordList.getLast());
        }*/

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

     /*   // Add a floating action click handler for creating new entries.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = androidVersions.size();
                // Add a new word to the end of the wordList.
                androidVersions.add("+ Word " + wordListSize);
                // Notify the adapter, that the data has changed so it can
                // update the RecyclerView to display the data.
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom.
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });*/
    }

    private ArrayList prepareData(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            ImageUrl androidVersion = new ImageUrl();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
