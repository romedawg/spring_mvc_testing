package com.romedawg.rome.Domain.Divy;

import javax.persistence.*;
import java.lang.reflect.Array;

@Entity
@Table(name="station")
public class Station {
//    @javax.persistence.Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer Id;
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id ;

    @Column(name = "station_id")
    private Integer StationId;
    @Column(name = "num_bikes_available")
    private Integer num_bikes_available;
    @Column(name = "num_ebikes_available")
    private Integer num_ebikes_available;
    @Column(name = "num_bikes_disabled")
    private Integer num_bikes_disabled;
    @Column(name = "num_docks_available")
    private Integer num_docks_available;
    @Column(name = "num_docks_disabled")
    private Integer num_docks_disabled;
    @Column(name = "is_installed")
    private Integer is_installed;
    @Column(name = "is_renting")
    private Integer is_renting;
    @Column(name = "is_returning")
    private Integer is_returning;
    @Column(name = "last_reported")
    private Integer last_reported;
    @Column(name = "eightd_has_available_keys")
    private Boolean eightd_has_available_keys;
    @Column(name = "eightd_active_station_services")
    private String eightd_active_station_services;

    public Integer getStationId() {
        return StationId;
    }

    public void setStationId(Integer stationId) {
        StationId = stationId;
    }

    public Integer getNum_bikes_available() {
        return num_bikes_available;
    }

    public void setNum_bikes_available(Integer num_bikes_available) {
        this.num_bikes_available = num_bikes_available;
    }

    public Integer getNum_ebikes_available() {
        return num_ebikes_available;
    }

    public void setNum_ebikes_available(Integer num_ebikes_available) {
        this.num_ebikes_available = num_ebikes_available;
    }

    public Integer getNum_bikes_disabled() {
        return num_bikes_disabled;
    }

    public void setNum_bikes_disabled(Integer num_bikes_disabled) {
        this.num_bikes_disabled = num_bikes_disabled;
    }

    public Integer getNum_docks_available() {
        return num_docks_available;
    }

    public void setNum_docks_available(Integer num_docks_available) {
        this.num_docks_available = num_docks_available;
    }

    public Integer getNum_docks_disabled() {
        return num_docks_disabled;
    }

    public void setNum_docks_disabled(Integer num_docks_disabled) {
        this.num_docks_disabled = num_docks_disabled;
    }

    public Integer getIs_installed() {
        return is_installed;
    }

    public void setIs_installed(Integer is_installed) {
        this.is_installed = is_installed;
    }

    public Integer getIs_renting() {
        return is_renting;
    }

    public void setIs_renting(Integer is_renting) {
        this.is_renting = is_renting;
    }

    public Integer getIs_returning() {
        return is_returning;
    }

    public void setIs_returning(Integer is_returning) {
        this.is_returning = is_returning;
    }

    public Integer getLast_reported() {
        return last_reported;
    }

    public void setLast_reported(Integer last_reported) {
        this.last_reported = last_reported;
    }

    public Boolean getEightd_has_available_keys() {
        return eightd_has_available_keys;
    }

    public void setEightd_has_available_keys(Boolean eightd_has_available_keys) {
        this.eightd_has_available_keys = eightd_has_available_keys;
    }

    public String getEightd_active_station_services() {
        return eightd_active_station_services;
    }

    public void setEightd_active_station_services(String eightd_active_station_services) {
        this.eightd_active_station_services = eightd_active_station_services;
    }
}

//{"station_id":"43",
//        "num_bikes_available":20,
//        "num_ebikes_available":0,
//        "num_bikes_disabled":0,
//        "num_docks_available":23,
//        "num_docks_disabled":0,
//        "is_installed":1,
//        "is_renting":1,
//        "is_returning":1,
//        "last_reported":1565357186,
//        "eightd_has_available_keys":false,
//        "eightd_active_station_services":[{"id":"817e33c3-bfa6-4f9b-9020-49b6ff4da18a"}]}
