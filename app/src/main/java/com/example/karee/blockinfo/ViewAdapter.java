package com.example.karee.blockinfo;

/**
 * Created by karee on 9/24/2017.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.CustomViewHolder> {

    private List<Statistic> StatisticList;
    private Context mContext;

    public ViewAdapter(Context context, List<Statistic> StatisticList) {
        this.StatisticList = StatisticList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Statistic Statistic = StatisticList.get(i);

        customViewHolder.text.setText(Statistic.getValue());
        customViewHolder.title.setText(Statistic.getTitle());
    }

    @Override
    public int getItemCount() {
        return (null != StatisticList ? StatisticList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView title;
        protected TextView text;

        public CustomViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.title);
            this.text = (TextView) view.findViewById(R.id.text);
        }
    }
}
