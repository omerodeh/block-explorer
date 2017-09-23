package com.example.karee.blockinfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import info.blockchain.api.statistics.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


/**
 * Created by karee on 8/25/2017.
 */

public class DownloadStatistics extends AsyncTask<Object, Object, String>  {
    public AsyncResponse delegate = null;

    @Override
    protected String doInBackground(Object... v) {

        Statistics stats = new Statistics();
        StatisticsResponse statsresponse;
        try {
            statsresponse = stats.getStats();
        } catch (Exception e){
            return "Epic Fail";
        }

//0

        return Double.toString(statsresponse.getDifficulty());


//        Client client = ClientBuilder.newClient();
//        Response response = client.target("https://blockchain.info/q/getdifficulty").request(MediaType.TEXT_PLAIN_TYPE).get();

//        System.out.println("status: " + response.getStatus());
//        System.out.println("headers: " + response.getHeaders());
//        System.out.println("body:" + response.readEntity(String.class));
//        System.out.println("error");


//        Chart txPerSec = stats.getChart("transactions-per-second", "5weeks", "8hours");
//
//        Map<String, Integer> pools = stats.getPools("5weeks");
//        return response.readEntity(String.class);
    }

    protected void onPostExecute(String result) {

        delegate.processFinish(result);
    }

}
