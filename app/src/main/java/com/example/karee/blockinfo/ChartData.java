package com.example.karee.blockinfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by karee on 9/26/2017.
 */

public class ChartData {
    private boolean ready;
    private String title;
    private String unit;
    private String period;
    private String description;
    private Integer[] x_values;
    private Double[] y_values;



    ChartData(String json){
        JSONObject jo;
        JSONArray ja;
        String values;
        try {
            jo = new JSONObject(json);
            title = jo.getString("name");
            unit = jo.getString("unit");
            period = jo.getString("period");
            description = jo.getString("description");
            values = jo.getString("values");
        } catch (JSONException e) {
            values="FAIL";

            System.out.println("Rest in peace");
        }


        try{
            ja = new JSONArray(values);
            x_values = new Integer[ja.length()];
            y_values = new Double[ja.length()];
            for (int i = 0; i < ja.length(); i++){
                String field = ja.get(i).toString();
                int y_index = field.indexOf("y");
                x_values[i] = Integer.parseInt(field.substring(field.indexOf("x") + 3 , y_index - 2));
                y_values[i] = Double.parseDouble(field.substring(y_index + 3, field.length()-1));



            }
        } catch (JSONException e){
            ;
        }



    }


    public String getTitle() {
        return title;
    }

    public String getUnit() {
        return unit;
    }

    public String getPeriod() {
        return period;
    }

    public String getDescription() {
        return description;
    }

    public Integer[] getX_values() {
        return x_values;
    }

    public Double[] getY_values() {
        return y_values;
    }

    public boolean isOk(){
        return ready;
    }
}
