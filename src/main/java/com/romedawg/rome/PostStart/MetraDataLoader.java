package com.romedawg.rome.PostStart;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.romedawg.rome.Domain.Metra.Route;
import com.romedawg.rome.Repositories.Metra.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

public class MetraDataLoader {

    @Autowired
    RoutesRepository routesRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    // Routes: this is from a file
    public void LoadRoutes() throws IOException {
        Route[] routes= objectMapper.readValue(new File("/Users/rrafacz/personal/rome/DataModels_Examples/routes.json"), Route[].class);

        for (int x=0;x<routes.length;x++){
            System.out.println(routes[x]);
            routesRepository.save(routes[x]);
        }
    }
}
