package com.romedawg.rome.controller;


import com.google.gson.*;
import com.romedawg.rome.Domain.Divy.StationInformation;
import com.romedawg.rome.Domain.Divy.StationServices;
import com.romedawg.rome.Repositories.Divy.StationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import org.json.*;


@Controller
public class CommuteController {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    

    @RequestMapping("/stations")
    public String station(Model model) {

        log.info("executing commute mapping");

        StringBuffer response = new StringBuffer();
        String divy_url = "https://gbfs.divvybikes.com/gbfs/es/station_status.json";

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
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
        } catch (Exception e) {
            log.info("stacktrace error");
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(response.toString());
        String stations = jsonObject.getJSONObject("data").toString();

        model.addAttribute("divy_data", stations);
        return "commute/commute";
    }

    @RequestMapping("/commute")
    public String commute(Model model) {

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
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
        } catch (Exception e) {
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

        String[] keySet;
        keySet = new String[12];
        // Working - this iterates thorugh the keyset and prints out the value
        int n = 0;
        while (id.hasNext()) {
            String key = id.next().toString();
            System.out.print(key + ":" + dd.get(key));
            keySet[n] = key;
            log.info("number: " + n + " keySet: " + keySet[n]);
            n = n + 1;
        }
        log.info("no more keys");

        StationInformation station = new StationInformation();
        StationServices stationService = new StationServices();
        station.setStation_id(dd.get("station_id").getAsInt());
        station.setExternal_id(dd.get("external_id").getAsString());
        station.setName(dd.get("name").getAsString());
        station.setShort_name(dd.get("short_name").getAsString());
        station.setLat(dd.get("lat").getAsFloat());
        station.setLon(dd.get("lon").getAsFloat());
        station.setRental_method(dd.get("rental_methods").getAsJsonArray());
        station.setCapacity(dd.get("capacity").getAsInt());
        station.setElectric_bike_surcharge_waiver(dd.get("electric_bike_surcharge_waiver").getAsBoolean());
        station.setEightd_has_key_dispenser(dd.get("eightd_has_key_dispenser").getAsBoolean());
//        station.setEightd_has_key_dispenser(dd.get("eightd_station_services").getAsBoolean());
        station.setHas_kiosk(dd.get("has_kiosk").getAsBoolean());

        model.addAttribute("divy_data", station);
        model.addAttribute("keySet", keySet[0]);
        return "commute/commute";
    }

}

