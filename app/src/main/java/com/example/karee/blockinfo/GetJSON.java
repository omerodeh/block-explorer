package com.example.karee.blockinfo;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;




/**
 * Created by karee on 8/25/2017.
 */

public class GetJSON extends AsyncTask<Object, Object, String> {
    public AsyncResponse delegate = null;
    private String url;

    GetJSON(String s){
        url = s;
    }

    @Override
    protected String doInBackground(Object... v) {
        JSONObject json;
        String s;

        try {
            json = readJsonFromUrl(url);
            s = json.toString();
        } catch (Exception e){
            s = "fail";
        }

        return s;

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } finally {
            is.close();
        }
    }

    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }

}
