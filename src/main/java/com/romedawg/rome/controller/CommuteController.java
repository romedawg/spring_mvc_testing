package com.romedawg.rome.controller;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

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

            //iterate through the stream and putinto an object(response)
            String inputLine;
            while ((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        if ( response_code != 200) {
            model.addAttribute("divy_data", Integer.toString(response_code) + ": " + "Check the URL" );
        } else {
            model.addAttribute("divy_data", response);
        }
        return "commute/commute";
    }
}
