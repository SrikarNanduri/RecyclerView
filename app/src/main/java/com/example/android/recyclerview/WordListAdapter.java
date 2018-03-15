package com.example.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by srikarn on 14-03-2018.
 */

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {

    private ArrayList<ImageUrl> android_text;

    private LayoutInflater mInflater;
    private ProgressBar mLoadingIndicator;

    public WordListAdapter(Context context, ArrayList android_text) {
        mInflater = LayoutInflater.from(context);
        this.android_text = android_text;
    }

    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordListAdapter.WordViewHolder holder, int position) {
        new ImageLoadTask(android_text.get(position).getAndroid_image_url(), holder.imageView, mLoadingIndicator).execute();
        holder.wordItemView.setText(android_text.get(position).getAndroid_version_name());
        //Picasso.with(context).load(android_versions.get(position).getAndroid_image_url()).resize(120, 60).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return android_text.size();
    }


    class WordViewHolder extends RecyclerView.ViewHolder  {
        public final TextView wordItemView;
        public final ImageView imageView;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            imageView =  itemView.findViewById(R.id.image);
            mLoadingIndicator =  itemView.findViewById(R.id.pb_loading_indicator);
            wordItemView =  itemView.findViewById(R.id.word);
            this.mAdapter = adapter;

        }
    }

}
