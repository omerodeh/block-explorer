package com.example.karee.blockinfo;


import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by karee on 9/24/2017.
 */

public class Statistic {

    private String title;
    private int id;
    private String value;

    //Constructor parses from json
    Statistic(String json) {

        int index = json.indexOf(":");
        String raw_title = json.substring(0, index).replaceAll("\"", "");
        Double raw_data = Double.parseDouble(json.substring(index + 1, json.length()));
        switch (raw_title) {
            case ("market_price_usd"):
                id = 1;
                title = "Market Price ($)";
                value = "$" + numberFormat(raw_data);
                break;
            case ("hash_rate"):
                id = 2;
                value = numberFormat(raw_data);
                title = "Hash Rate";
                break;

            case ("n_btc_mined"):
                id = 3;
                title = "Bitcoin Mined";
                value = numberFormat(raw_data);
                break;
            case ("n_tx"):
                id = 4;
                title = "Number of Transactions";
                value = numberFormat(raw_data);
                break;
            case ("n_blocks_mined"):
                id = 5;
                title = "Blocks Mined";
                value = numberFormat(raw_data);
                break;
            case ("minutes_between_blocks"):
                id = 6;
                title = "Time Between Blocks (min)";
                value = numberFormat(raw_data);
                break;
            case ("totalbc"):
                id = 7;
                title = "Total Bitcoins in Ciruclation";
                value = numberFormat(raw_data);
                break;
            case ("n_blocks_total"):
                id = 8;
                title = "Total Number of Blocks";
                value = numberFormat(raw_data);
                break;

            case ("estimated_transaction_volume_usd"):
                id = 9;
                title = "Estimated Transaction Volume ($)";
                value = numberFormat(raw_data);
                break;
            case ("blocks_size"):
                id = 10;
                title = "Block Size";
                value = numberFormat(raw_data);
                break;
            case ("miners_revenue_usd"):
                id = 11;
                title = "Miner Revenue ($)";
                value = numberFormat(raw_data);
                break;

            case ("miners_revenue_btc"):
                id = 12;
                title = "Miner Revenue (BTC)";
                value = numberFormat(raw_data);
                break;
            case ("nextretarget"):
                id = 13;
                title = "Retarget in";
                value = numberFormat(raw_data);
                //value - current blockheight
                break;

            case ("difficulty"):
                id = 14;
                title = "Current Difficulty";
                value = numberFormat(raw_data);
                break;

            case ("total_btc_sent"):
                id = 15;
                title = "Total BTC Sent";
                value = numberFormat(raw_data);
                break;
            case ("trade_volume_btc"):
                id = 16;
                title = "Trade Volume (BTC)";
                value = numberFormat(raw_data);
                break;
            case ("trade_volume_usd"):
                id = 17;
                title = "Trade Volume (USD)";
                value = numberFormat(raw_data);
                break;
        }
    }

    private String numberFormat(double d){
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        return nf.format(d);
    }


    public String getTitle(){
        return title;
    }

    public String getValue(){
        return value;
    }

    public int getId(){
        return id;
    }

}