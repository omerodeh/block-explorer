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

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.GraphView;
import android.os.Parcelable;
import com.jjoe64.graphview.series.BaseSeries;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.BarGraphSeries;

import java.util.List;
import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CustomViewHolder> {

    private List<ChartData> ChartList;
    private Context mContext;
    LineGraphSeries<DataPoint> series;


    public CardAdapter(Context context, List<ChartData> ChartList) {
        this.ChartList = ChartList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chart_card, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {

        ChartData data = ChartList.get(i);
        int numOfValues = data.getX_values().length;
        DataPoint[] points = new DataPoint[numOfValues];
        for (int j = 0; j < numOfValues; j++){
            points[j] = (new DataPoint(data.getX_values()[j], data.getY_values()[j]));
        }

        series = new LineGraphSeries<>(points);
        customViewHolder.graph.addSeries(series);


    }

    @Override
    public int getItemCount() {
        return (null != ChartList ? ChartList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected GraphView graph;

        public CustomViewHolder(View view) {

            super(view);
            graph = (GraphView) view.findViewById(R.id.graph);

        }
    }
}
