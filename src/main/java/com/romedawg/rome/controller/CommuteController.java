package com.romedawg.rome.controller;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class CommuteController {


    public String parseDivy() throws Exception{
        String divy_url = "https://feeds.divvybikes.com/stations/stations.json";

        URL url = new URL(divy_url);
        return divy_url;
    }

    @RequestMapping("/commute")
    public String commute(Model model){

        GsonJsonParser gsonJsonParser = new GsonJsonParser();

        StringBuffer response = new StringBuffer();
        String divy_url = "https://feeds.divvybikes.com/stations/stations.json";
        int response_code = 503;
        try {
            //Setup url connection
            URL url = new URL(divy_url);
            HttpURLConnection http_conn = (HttpURLConnection) url.openConnection();
            http_conn.setRequestMethod("GET");
            response_code = http_conn.getResponseCode();

            //Read input stream from the url connection(http_conn)
            BufferedReader br = new BufferedReader(new InputStreamReader(http_conn.getInputStream()));

            //iterate through the stream and put into an object(response)
            String inputLine;
            while ((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        //Parse through the divy response object. filter out station pertinent to you.

        String json = response.toString();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);

        JsonObject stations = new JsonObject();
        JsonArray datasets = new JsonArray();
        JsonElement station_list;
        if (element.isJsonObject()){
            stations = element.getAsJsonObject();
            station_list = stations.get("stationBeanList");
            datasets = station_list.getAsJsonArray();
        }

        System.out.println("test");
        model.addAttribute("divy_data", datasets.toString());
        return "commute/commute";
    }
}
