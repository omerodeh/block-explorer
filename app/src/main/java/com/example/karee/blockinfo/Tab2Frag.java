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

import com.jjoe64.graphview.GraphView;

import java.util.ArrayList;
import java.util.List;

import info.blockchain.api.statistics.Chart;

/**
 * Created by User on 2/28/2017.
 */

public class Tab2Frag extends Fragment implements MultipleAsyncResponse {
    private static final String TAG = "Tab2Frag";
    private RecyclerView recyclerView;
    private ProgressBar mProgressBar;
    private GridLayoutManager gridLayoutManager;
    private CardAdapter adapter;


    private final String[] urls = { "https://api.blockchain.info/charts/transactions-per-second?timespan=5weeks&rollingAverage=8hours&format=json",
                                    "https://api.blockchain.info/charts/market-price"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            MultipleJSON dl = new MultipleJSON(urls);
            dl.delegate = this;
            dl.execute();



        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.tab2_frag,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        return view;
    }

    @Override
    public void processFinish(List<String> output){
        List<ChartData> data = new ArrayList<>();
        for (int i = 0; i < output.size(); i++) {
            data.add(new ChartData(output.get(i)));
        }




        adapter = new CardAdapter(getActivity(), data);
        recyclerView.setAdapter(adapter);
        mProgressBar.setVisibility(View.GONE);



    }
}
