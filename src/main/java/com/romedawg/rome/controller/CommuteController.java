package com.romedawg.rome.controller;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.romedawg.rome.Domain.Station;
import com.romedawg.rome.Domain.StationServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

@Controller
public class CommuteController {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping("/commute")
    public String commute(Model model){

        Station station = new Station();
        StationServices stationService = new StationServices();

        log.info("executing commute mapping");
        GsonJsonParser gsonJsonParser = new GsonJsonParser();

        StringBuffer response = new StringBuffer();
        String divy_url = "https://gbfs.divvybikes.com/gbfs/es/station_information.json";
        log.info("attempting to hit divvy json feed");
        int response_code = 503;
        try {
            //Setup url connection
            log.info("setting divy url object");
            URL url = new URL(divy_url);
            HttpURLConnection http_conn = (HttpURLConnection) url.openConnection();
            http_conn.setRequestMethod("GET");
            log.info("http response cod");

            //Read input stream from the url connection(http_conn)
            log.info("Buffer input reader");
            BufferedReader br = new BufferedReader(new InputStreamReader(http_conn.getInputStream()));

            //iterate through the stream and put into an object(response)
            log.info("String apppending lines");
            String inputLine;
            while ((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
        } catch (Exception e){
            log.info("stacktrace error");
            e.printStackTrace();
        }

        //Parse through the divy response object. filter out station pertinent to you.
        String json = response.toString();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);

        log.info("json object attempt");
        JsonObject stations = new JsonObject();

        log.info("attempting to create a json object.");
        stations = element.getAsJsonObject();
        JsonElement dataSetStations = stations.get("data");
        JsonObject stationDataSet = dataSetStations.getAsJsonObject();
        JsonElement stationList = stationDataSet.get("stations");
        JsonArray stationArray = stationList.getAsJsonArray();

//        for (int i=0;i<stationArray.size();i++){
//            log.info("station: "+stationArray.get(i));
//        }

        // dd pulls the 1st record, id is just an iterator.
        JsonObject dd = stationArray.get(1).getAsJsonObject();
        Iterator id = dd.keySet().iterator();

        // Working - this iterates thorugh the keyset and prints out the value
        while(id.hasNext()){
            String key = id.next().toString();

            System.out.print(key+":" + dd.get(key));

        }


//        Integer stationid = dd.get("station_id");
//        Integer stationId = dd.get("station_id").getAsInt();
//        station.setStation_id(stationId);



        model.addAttribute("divy_data",station.getStation_id());
        return "commute/commute";
    }
}


// Divvy Data station list-> java object
//
//