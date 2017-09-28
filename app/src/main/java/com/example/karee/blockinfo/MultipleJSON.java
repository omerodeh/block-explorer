package com.example.karee.blockinfo;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by karee on 9/27/2017.
 */

public class MultipleJSON extends AsyncTask<Object, Object, List<String>> {

    public MultipleAsyncResponse delegate = null;
    private String[] urls;

    MultipleJSON(String[] s){
        urls = s;
    }

    @Override
    protected List<String> doInBackground(Object... v) {
        List<JSONObject> json = new ArrayList<>();
        List<String> s = new ArrayList<>();
        for (int i = 0; i < urls.length; i++){
            try {
                s.add(readJsonFromUrl(urls[i]).toString());
            } catch (Exception e){
                s.add("fail");
            }
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

    protected void onPostExecute(List<String> result) {
        delegate.processFinish(result);
    }


}
