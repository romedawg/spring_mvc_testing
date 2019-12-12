package com.romedawg.rome.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.romedawg.rome.Domain.Catalog;
import com.romedawg.rome.Repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.Date;

@Controller
public class AlbumController {

    @Autowired
    CatalogRepository catalogRepository;

    @RequestMapping("/albums")
    public String albums(Model model){


        Date now = new Date();

        ObjectMapper mapper = new ObjectMapper();

        Catalog catalog = new Catalog();
        try {
            // File /tmp/test.json = {"artist":"Ozzy Osborne","album":"Diary of a Madman"}
            catalog = mapper.readValue(new File("/tmp/test.json"), Catalog.class);
            System.out.println(catalog);
            catalogRepository.save(catalog);
        } catch (Exception e){
            e.printStackTrace();
        }

//        // java object to Json doc
//        Catalog catalog = createAlbum("Wu Lyf", "Go Tell Fire to the Mountain");

//        try {
//            mapper.writeValue(new File("/tmp/test.json"), catalog);
//            String jsonString = mapper.writeValueAsString(catalog);
//            System.out.println(jsonString);
//            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(catalog);
//            System.out.println(jsonInString2);
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        model.addAttribute("album", catalog.toString());
        return "music/album";
    }

    public Catalog createAlbum(String artist, String album){
        Catalog catalog = new Catalog();
        catalog.setArtist(artist);
        catalog.setAlbum(album);
//        catalog.setId(1);
        catalogRepository.save(catalog);
        return catalog;
    }
}
