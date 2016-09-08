package com.pyze.samples.eventsampleandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pyze.samples.eventsampleandroid.R;

/**
 * Created by jesudas on 06/09/16.
 */
public abstract class PyzeBaseAdapter extends RecyclerView.Adapter<PyzeBaseAdapter.ViewHolder> {
    String [] mDataSet;

    public PyzeBaseAdapter(String[] dataSet){
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder((Button) v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mButtonView.setText(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    abstract protected void onItemClick(Context context, String itemName);

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button mButtonView;
        public ViewHolder(final Button itemView) {
            super(itemView);
            mButtonView = itemView;
            mButtonView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick(itemView.getContext(),itemView.getText().toString());
                }
            });
        }
    }
}
