package com.example.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by srikarn on 14-03-2018.
 */

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private ArrayList<ImageUrl> android_text;
    Context context;
    private LayoutInflater mInflater;



    public WordListAdapter(Context context, ArrayList android_text) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.android_text = android_text;
    }

    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(final WordListAdapter.WordViewHolder holder, int position) {
        // new ImageLoadTask(android_text.get(position).getAndroid_image_url(), holder.imageView, mLoadingIndicator).execute();
        // TODO: 16-03-2018 uncomment ImageLoadTask above to use asyncTask to load images in background and comment the below code if you do that, comment till the next todo.
        holder.wordItemView.setText(android_text.get(position).get_Text());
        holder.mLoadingIndicator.setVisibility(View.VISIBLE);
        Picasso.with(context).load(android_text.get(position).getAndroid_image_url())
                .resize(800, 500)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.mLoadingIndicator.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });

        // TODO: 16-03-2018 comment the code from last todo to here if you use asyncTask to load the images.
    }


    @Override
    public int getItemCount() {
        return android_text.size();
    }


    class WordViewHolder extends RecyclerView.ViewHolder  {
        public final TextView wordItemView;
        public final ImageView imageView;
        final WordListAdapter mAdapter;
        private ProgressBar mLoadingIndicator;
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            imageView =  itemView.findViewById(R.id.image);
            mLoadingIndicator =  itemView.findViewById(R.id.pb_loading_indicator);
            wordItemView =  itemView.findViewById(R.id.word);
            this.mAdapter = adapter;

        }
    }

}
