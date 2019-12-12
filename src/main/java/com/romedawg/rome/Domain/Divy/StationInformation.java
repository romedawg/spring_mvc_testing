package com.romedawg.rome.Domain.Divy;

import com.google.gson.JsonArray;

public class StationInformation {

    private Integer station_id;
    private String external_id;
    private String name;
    private String short_name;
    private Float lat;
    private Float lon;
    private JsonArray rental_method;
    private Integer capacity;
    private Boolean electric_bike_surcharge_waiver;
    private Boolean eightd_has_key_dispenser;
    private StationServices eightd_station_services;
    private Boolean has_kiosk;

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public JsonArray getRental_method() {
        return rental_method;
    }

    public void setRental_method(JsonArray rental_method) {
        this.rental_method = rental_method;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getElectric_bike_surcharge_waiver() {
        return electric_bike_surcharge_waiver;
    }

    public void setElectric_bike_surcharge_waiver(Boolean electric_bike_surcharge_waiver) {
        this.electric_bike_surcharge_waiver = electric_bike_surcharge_waiver;
    }

    public Boolean getEightd_has_key_dispenser() {
        return eightd_has_key_dispenser;
    }

    public void setEightd_has_key_dispenser(Boolean eightd_has_key_dispenser) {
        this.eightd_has_key_dispenser = eightd_has_key_dispenser;
    }

    public StationServices getEightd_station_services() {
        return eightd_station_services;
    }

    public void setEightd_station_services(StationServices eightd_station_services) {
        this.eightd_station_services = eightd_station_services;
    }

    public Boolean getHas_kiosk() {
        return has_kiosk;
    }

    public void setHas_kiosk(Boolean has_kiosk) {
        this.has_kiosk = has_kiosk;
    }

//    public String getSetter(Iterator iterator){
//        return keyName.substring(0,-1).toUpperCase().toString();
//    }
}

// Data Structure
//        station_id:"77"
//        external_id":"a3a4daa1-a135-11e9-9cda-0a87ae2ba916",
//        "name":"Clinton St & Madison St",
//        "short_name":"TA1305000032",
//        "lat":41.882242,
//        "lon":-87.641066,
//        "rental_methods":["TRANSITCARD","CREDITCARD","KEY"],
//        "capacity":31,
//        "electric_bike_surcharge_waiver":false,
//        "eightd_has_key_dispenser":false,
//        "eightd_station_services":
//            [{"id":"67ac7df5-d3da-4867-b7a1-cb70bb339671",
//        "service_type":"ATTENDED_SERVICE",
//        "bikes_availability":"UNLIMITED",
//        "docks_availability":"UNLIMITED",
//        "name":"Valet",
//        "description":"Divvy staff are here to load the station with extra bikes and make sure that there’s a space for you to dock your bike.",
//        "schedule_description":"Monday-Friday; 6:00am-10:30am & 3:30pm-8:00pm",
//        "link_for_more_info":"https://www.divvybikes.com/valet"}],
//        "has_kiosk":true
