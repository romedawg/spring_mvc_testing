package com.romedawg.rome.PostConstruct;

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
import org.apache.commons.lang3.concurrent.BasicThreadFactory;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// TODO run seperately in a thread.

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

    private ExecutorService executorService;

    @PostConstruct
    public void init() throws IOException {

        BasicThreadFactory basicThreadFactory = new BasicThreadFactory.Builder()
                .namingPattern("bean-thread-%d").build();

        executorService = Executors.newSingleThreadExecutor(basicThreadFactory);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    LoadRoutes();
                    // TODO turn back on
                    loadTrips();
                    loadBNSFStops();
                } catch (Exception e){
                    log.error("error: ", e);
                }
            }
        });
    }

    @PreDestroy
    public void beanDestroy(){
        if (executorService != null){
            executorService.shutdown();
        }
    }

    // Quick small set of data - should only be executed once
    // Loads each Metra train route(i.e BNFS, etc..)
    public void LoadRoutes() throws IOException {
        StringBuffer sb = fetchMetraExternalData("https://gtfsapi.metrarail.com/gtfs/schedule/routes");
        Route.Builder[] newRoutes = objectMapper.readValue(sb.toString(), Route.Builder[].class);

        log.info("loading metra routes");
        List<Route> existingRoutes = routesRepository.findAll();

        for (Route.Builder newroute:newRoutes){
            log.info(String.format("new url request, route id: %s", newroute.build().getRoute_id()));
            if (routesRepository.findRouteID(newroute.build().getRoute_id()) == ""){
                log.debug(String.format("%s does not exist, adding it.", newroute.build().getRoute_id()));
            }
        }
        log.info("metra routes done loading");

    }

    // Trips: These are Begining to end trip info
    // I.E: Chicago to Union station and vice versa
    // Should be loaded every 24 hours initially(unless delays occur, then should initiate.
    // TODO if while trip interruption, load, sleep, and repeat.
    public void loadTrips() throws IOException {
        String tripData = "https://gtfsapi.metrarail.com/gtfs/schedule/trips";
        StringBuffer tripBuffer = fetchMetraExternalData(tripData);

        Trip.Builder[] newTripData = objectMapper.readValue(tripBuffer.toString(), Trip.Builder[].class);

        log.info("loading metra trip routes");
        // Check if trip ID already exists, if not add it to the db.
        // TODO check trip table for the stop table if the routes doesnt exist in stop table, fetch.
        for (int x=0;x<newTripData.length;x++){
            String tripId = newTripData[x].build().getTrip_id();
            if (tripRepository.findTripID(tripId) == null){
                log.info(String.format("add missing trip_id: %s", tripId.toString()));
                tripRepository.save(newTripData[x].build());
            }
        }
        log.info("done loading trip routes");
    }

    public void loadBNSFStops() throws IOException{
        StringBuffer sb = fetchMetraExternalData("https://gtfsapi.metrarail.com/gtfs/schedule/stop_times");
        Stop.Builder[] newStopsData = objectMapper.readValue(sb.toString(), Stop.Builder[].class);

        log.info("load metra newStopsData");
        for (int x=0;x<newStopsData.length;x++){
            String tripID = newStopsData[x].build().getTrip_id();
            String arrivalTime = newStopsData[x].build().getArrival_time();
//            if (stopRepository.findTripID(tripID, arrivalTime) == null){
//                log.info(String.format("saving stop id with: %s arrival time: %s", tripID.toString(), arrivalTime.toString()));
//                stopRepository.save(newStopsData[x].build());
//            }
            System.out.println(newStopsData[x].build().toString());
            stopRepository.saveAndFlush(newStopsData[x].build());
        }
        log.info("metra newStopsData loaded");
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
