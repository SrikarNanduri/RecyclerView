package com.example.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by srikarn on 14-03-2018.
 */

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {

    private ArrayList<ImageUrl> android_versions;

    private LayoutInflater mInflater;
    private Context context;
    private ProgressBar mLoadingIndicator;

    public WordListAdapter(Context context, ArrayList android_versions) {
        mInflater = LayoutInflater.from(context);
        this.android_versions = android_versions;
        this.context = context;
       // this.mLoadingIndicator= mLoadingIndicator;
    }

    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordListAdapter.WordViewHolder holder, int position) {
        holder.wordItemView.setText(android_versions.get(position).getAndroid_version_name());

        new ImageLoadTask(android_versions.get(position).getAndroid_image_url(), holder.imageView, mLoadingIndicator).execute();
        //Picasso.with(context).load(android_versions.get(position).getAndroid_image_url()).resize(120, 60).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return android_versions.size();
    }


    class WordViewHolder extends RecyclerView.ViewHolder  {
        public final TextView wordItemView;
        public final ImageView imageView;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            mLoadingIndicator = (ProgressBar) itemView.findViewById(R.id.pb_loading_indicator);

            this.mAdapter = adapter;

        }

       /* @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
// Use that to access the affected item in mWordList.

// Change the word in the mWordList.
// Notify the adapter, that the data has changed so it can
// update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }*/
    }

}
