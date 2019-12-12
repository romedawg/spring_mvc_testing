package com.romedawg.rome.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.romedawg.rome.Domain.Metra.*;
import com.romedawg.rome.Repositories.Metra.StopRepository;
import com.romedawg.rome.Repositories.Metra.RoutesRepository;
import com.romedawg.rome.Repositories.TripRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Controller
@Component
public class MetraController {
    @Value("${METRA_URL_USERNAME}")
    private String metraUrlUsername;
    @Value("${METRAL_URL_PASSWORD}")
    private String metraUrlPassword;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private TripRepository tripRepository;
    StopRepository stopRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/metra")
    public String metra(Model model) throws IOException {

        String tripUpdates = "https://gtfsapi.metrarail.com/gtfs/tripUpdates";
        String routedata = "";

        StringBuffer bufferTripUpdate = metraUrlData("https://gtfsapi.metrarail.com/gtfs/tripUpdates");

        String stopData = "https://gtfsapi.metrarail.com/gtfs/schedule/stop_times/BNSF_BN1264_V1_C";
        System.out.println("load ROUTES");
        StringBuffer bufferStop = metraUrlData(stopData);
        System.out.println("load stops");
        loadBNSFStops(bufferStop);

        Stop[] data = stopRepository.findStopsByTrip_id("BNSF_BN1264_V1_C");
        model.addAttribute("divy_data", data.toString());
        return "metra/metra";

    }

//    public void loadStopTestData() throws IOException{
//        System.out.println("loading stop_data");
//        Stop[] stop = objectMapper.readValue(new File("/Users/rrafacz/personal/rome/DataModels_Examples/stop_times.json"), Stop[].class);
//        for (int n=0;n<stop.length;n++){
//            System.out.println(stop[n]);
//            stopRepository.save(stop[n]);
//        }
//    }

    // Need to load only BNSF trips ids for the stop
    // Query Routes table and return all BNSF* id's
    // make url request for each id
    // load each entry into the stops table
    public void loadBNSFStops(StringBuffer data) throws IOException{
        Stop[] stops = objectMapper.readValue(data.toString(), Stop[].class);
        for (int x=0;x<stops.length;x++){
            stops[x].setId(x);
            System.out.println(stops[x]);
            stopRepository.save(stops[x]);
        }
    }

    // Trips: load from metra URL
    public void loadTrips() throws IOException {
        String tripData = "https://gtfsapi.metrarail.com/gtfs/schedule/trips";
        StringBuffer tripBuffer = metraUrlData(tripData);
        Trip[] trips = objectMapper.readValue(tripBuffer.toString(), Trip[].class);

        for (int x=0;x<trips.length;x++){
            System.out.println(trips[x]);
            tripRepository.save(trips[x]);
        }
    }

    // Makes the URL request and returns it in a StringBuffer Object
    public StringBuffer metraUrlData(String URL){
        log.info(metraUrlUsername);

        String metraUpdates = URL;

        StringBuffer buffer = new StringBuffer();

        String auth = metraUrlUsername + ":" + metraUrlPassword;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authenticatedValue = "Basic " + new String(encodedAuth);

        try {
            URL url = new URL(metraUpdates);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestProperty("Authorization", authenticatedValue );
            httpConn.setRequestMethod("GET");

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            String inputLine;
            while ((inputLine = bufReader.readLine()) != null){
                buffer.append(inputLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return buffer;
    }
}
