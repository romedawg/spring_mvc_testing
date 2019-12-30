package com.romedawg.rome.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.romedawg.rome.Domain.Metra.*;
import com.romedawg.rome.Repositories.Metra.RoutesRepository;
import com.romedawg.rome.Repositories.Metra.StopRepository;
import com.romedawg.rome.Repositories.TripRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.id.UUIDGenerator;
import org.hibernate.type.UUIDCharType;
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
import java.util.UUID;

@Controller
@Component
public class MetraController {
    @Value("${METRA_URL_USERNAME}")
    private String metraUrlUsername;
    @Value("${METRAL_URL_PASSWORD}")
    private String metraUrlPassword;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    RoutesRepository routesRepository;
    TripRepository tripRepository;

    @Autowired
    StopRepository stopRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/metra")
    public String metra(Model model) throws IOException {

        String stopData = "https://gtfsapi.metrarail.com/gtfs/schedule/stop_times";
        System.out.println("load ROUTES");
        LoadRoutes();
        System.out.println("Routes Loaded");


        System.out.println("load stops");
        loadBNSFStops();

//        Stop[] data = stopRepository.findStopsByTrip_id("BNSF_BN1264_V1_C");
        model.addAttribute("divy_data", "data.toString()");
        return "metra/metra";
    }


    // Need to load only BNSF trips ids for the stop
    // Query Routes table and return all BNSF* id's
    // make url request for each id
    // load each entry into the stops table
    public void loadBNSFStops() throws IOException{
        StringBuffer sb = fetchMetraExternalData("https://gtfsapi.metrarail.com/gtfs/schedule/stop_times");
//        System.out.println("string buffer object is:");
//        System.out.println(sb.toString());
        Stop.Builder[] stops = objectMapper.readValue(sb.toString(), Stop.Builder[].class);
        for (int x=0;x<stops.length;x++){
            System.out.println(stops[x].build().toString());
            stopRepository.saveAndFlush(stops[x].build());
        }
    }

    public void LoadRoutes() throws IOException {
        StringBuffer sb = fetchMetraExternalData("https://gtfsapi.metrarail.com/gtfs/schedule/routes");
        Route.Builder[] routes= objectMapper.readValue(sb.toString(), Route.Builder[].class);

        for (int x=0;x<routes.length;x++){
            System.out.println(routes[x].build().toString());
            routesRepository.saveAndFlush(routes[x].build());
        }
    }

    // Trips: load from metra URL
    public void loadTrips() throws IOException {
//        String tripUpdates = "https://gtfsapi.metrarail.com/gtfs/tripUpdates";

        String tripData = "https://gtfsapi.metrarail.com/gtfs/schedule/trips";
        StringBuffer tripBuffer = fetchMetraExternalData(tripData);
        Trip[] trips = objectMapper.readValue(tripBuffer.toString(), Trip[].class);

        for (int x=0;x<trips.length;x++){
            System.out.println(trips[x]);
            tripRepository.save(trips[x]);
        }
    }

    // Makes the URL request and returns it in a StringBuffer Object
    public StringBuffer fetchMetraExternalData(String URL){
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
