package com.romedawg.rome.Domain.Metra;

import javax.persistence.*;

@Entity
@Table(name="trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String route_id;

    private String service_id;

    private String trip_id;

    private String trip_headsign;

    private String block_id;

    private String shape_id;

    private Integer direction_id;

    public Trip() {
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", route_id='" + route_id + '\'' +
                ", service_id='" + service_id + '\'' +
                ", trip_id='" + trip_id + '\'' +
                ", trip_headsign='" + trip_headsign + '\'' +
                ", block_id='" + block_id + '\'' +
                ", shape_id='" + shape_id + '\'' +
                ", direction_id=" + direction_id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getTrip_headsign() {
        return trip_headsign;
    }

    public void setTrip_headsign(String trip_headsign) {
        this.trip_headsign = trip_headsign;
    }

    public String getBlock_id() {
        return block_id;
    }

    public void setBlock_id(String block_id) {
        this.block_id = block_id;
    }

    public String getShape_id() {
        return shape_id;
    }

    public void setShape_id(String shape_id) {
        this.shape_id = shape_id;
    }

    public Integer getDirection_id() {
        return direction_id;
    }

    public void setDirection_id(Integer direction_id) {
        this.direction_id = direction_id;
    }
}


//{"route_id":"BNSF",
//        "service_id":"A1",
//        "trip_id":"BNSF_BN1200_V1_A",
//        "trip_headsign":"Chicago Union Station",
//        "block_id":"",
//        "shape_id":"BNSF_IB_1",
//        "direction_id":1}
