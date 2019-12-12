package com.romedawg.rome.Domain.Metra;

import javax.persistence.*;

@Entity
@Table(name="stop")
public class Stop {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "trip_id")
    private String trip_id;
    private String arrival_time;
    private String departure_time;
    private String stop_id;
    private Integer stop_sequence;
    private Integer pickup_type;
    private Integer drop_off_type;
    private Integer center_boarding;
    private Integer south_boarding;
    private Integer bikes_allowed;
    private Integer notice;

    public Stop() {
    }

    @Override
    public String toString() {
        return "Stop{" +
                "id=" + id +
                ", trip_id='" + trip_id + '\'' +
                ", arrival_time='" + arrival_time + '\'' +
                ", departure_time='" + departure_time + '\'' +
                ", stop_id='" + stop_id + '\'' +
                ", stop_sequence=" + stop_sequence +
                ", pickup_type=" + pickup_type +
                ", drop_off_type=" + drop_off_type +
                ", center_boarding=" + center_boarding +
                ", south_boarding=" + south_boarding +
                ", bikes_allowed=" + bikes_allowed +
                ", notice=" + notice +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getStop_id() {
        return stop_id;
    }

    public void setStop_id(String stop_id) {
        this.stop_id = stop_id;
    }

    public Integer getStop_sequence() {
        return stop_sequence;
    }

    public void setStop_sequence(Integer stop_sequence) {
        this.stop_sequence = stop_sequence;
    }

    public Integer getPickup_type() {
        return pickup_type;
    }

    public void setPickup_type(Integer pickup_type) {
        this.pickup_type = pickup_type;
    }

    public Integer getDrop_off_type() {
        return drop_off_type;
    }

    public void setDrop_off_type(Integer drop_off_type) {
        this.drop_off_type = drop_off_type;
    }

    public Integer getCenter_boarding() {
        return center_boarding;
    }

    public void setCenter_boarding(Integer center_boarding) {
        this.center_boarding = center_boarding;
    }

    public Integer getSouth_boarding() {
        return south_boarding;
    }

    public void setSouth_boarding(Integer south_boarding) {
        this.south_boarding = south_boarding;
    }

    public Integer getBikes_allowed() {
        return bikes_allowed;
    }

    public void setBikes_allowed(Integer bikes_allowed) {
        this.bikes_allowed = bikes_allowed;
    }

    public Integer getNotice() {
        return notice;
    }

    public void setNotice(Integer notice) {
        this.notice = notice;
    }
}


/***
 {"trip_id":"BNSF_BN1264_V1_C",
 "arrival_time":"11:47:00",
 "departure_time":"11:47:00",
 "stop_id":"CUS",
 "stop_sequence":28,
 "pickup_type":0,
 "drop_off_type":0,
 "center_boarding":0,
 "south_boarding":0,
 "bikes_allowed":1,
 "notice":0}]
 ***/
