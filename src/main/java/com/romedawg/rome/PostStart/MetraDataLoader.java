package com.romedawg.rome.PostStart;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.romedawg.rome.Domain.Metra.Route;
import com.romedawg.rome.Domain.Metra.Stop;
import com.romedawg.rome.Domain.Metra.Trip;
import com.romedawg.rome.Repositories.Metra.RoutesRepository;
import com.romedawg.rome.Repositories.Metra.StopRepository;
import com.romedawg.rome.Repositories.TripRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
public class MetraDataLoader {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Value("${METRA_URL_USERNAME}")
    private String metraUrlUsername;
    @Value("${METRAL_URL_PASSWORD}")
    private String metraUrlPassword;

    @Autowired
    RoutesRepository routesRepository;
    @Autowired
    StopRepository stopRepository;
    @Autowired
    TripRepository tripRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() throws IOException {
        LoadRoutes();
        loadTrips();
//        loadBNSFStops();
    }

    public void LoadRoutes() throws IOException {
        StringBuffer sb = fetchMetraExternalData("https://gtfsapi.metrarail.com/gtfs/schedule/routes");
        Route.Builder[] routes= objectMapper.readValue(sb.toString(), Route.Builder[].class);

        log.info("loading metra routes");
        for (int x=0;x<routes.length;x++){
            routesRepository.saveAndFlush(routes[x].build());
        }
        log.info("metra routes loaded");
    }

    public void loadBNSFStops() throws IOException{
        StringBuffer sb = fetchMetraExternalData("https://gtfsapi.metrarail.com/gtfs/schedule/stop_times");
        Stop.Builder[] stops = objectMapper.readValue(sb.toString(), Stop.Builder[].class);

        log.info("load metra stops");
        for (int x=0;x<stops.length;x++){
            System.out.println(stops[x].build().toString());
            stopRepository.saveAndFlush(stops[x].build());
        }
        log.info("metra stops loaded");
    }

    // Trips: load from metra URL
    public void loadTrips() throws IOException {
        String tripData = "https://gtfsapi.metrarail.com/gtfs/schedule/trips";
        StringBuffer tripBuffer = fetchMetraExternalData(tripData);

        Trip.Builder[] trips = objectMapper.readValue(tripBuffer.toString(), Trip.Builder[].class);

        log.info("loading metra trip routes");
        for (int x=0;x<trips.length;x++){
            tripRepository.save(trips[x].build());
        }
        log.info("done loading trip routes");

    }

    public StringBuffer fetchMetraExternalData(String URL){
        log.info(metraUrlUsername);

        String metraUpdates = URL;

        StringBuffer buffer = new StringBuffer();

        String auth = metraUrlUsername + ":" + metraUrlPassword;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authenticatedValue = "Basic " + new String(encodedAuth);

        try {
            java.net.URL url = new URL(metraUpdates);
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
