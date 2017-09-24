package com.example.karee.blockinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karee on 9/24/2017.
 */

public class Tab1Frag extends Fragment implements AsyncResponse{
    private RecyclerView recyclerView;
    private ProgressBar mProgressBar;
    private GridLayoutManager gridLayoutManager;
    private ViewAdapter adapter;
    List<Statistic> data = new ArrayList<Statistic>();
    String jss;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GetJSON dl = new GetJSON("https://api.blockchain.info/stats");
        dl.delegate = this;
        dl.execute();

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.tab1_frag,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);


        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);


    return view;


    }

    @Override
    public void processFinish(String output){

        String[] stats = output.split("\\{|\\,|\\}");
        List<Statistic> data = new ArrayList<Statistic>();
        for (int i = 1; i < stats.length-1; i++) {
            Statistic stat = new Statistic(stats[i]);
            if (stat.getTitle() != null) {
                data.add(stat);
            }
        }

        adapter = new ViewAdapter(getActivity(), data);
        recyclerView.setAdapter(adapter);
        mProgressBar.setVisibility(View.GONE);



    }
}
