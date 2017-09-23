package com.example.karee.blockinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AsyncResponse {

TextView testView;
    String diff;
    String jss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        DownloadStatistics dl = new DownloadStatistics();
        JSONparse dl = new JSONparse();
        dl.delegate = this;
        dl.execute();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void processFinish(String output){
        diff = output;
        jss = output;
        testView = (TextView) findViewById(R.id.testView);
        testView.setText(diff);

        testView.setText(jss);

    }


//    public class ImageAdapter extends BaseAdapter {
//        private Context mContext;
//
//        private Integer[] m
//    }
}
