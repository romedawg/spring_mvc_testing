package com.romedawg.rome.Domain.Metra;


import javax.persistence.*;

@Entity
@Table(name="stop")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "trip_id")
    private String trip_id;
    @Column(name="arrival_time")
    private String arrival_time;
    @Column(name="departure_time")
    private String departure_time;
    @Column(name="stop_id")
    private String stop_id;
    @Column(name="stop_sequence")
    private Integer stop_sequence;
    @Column(name="pickup_type")
    private Integer pickup_type;
    @Column(name="drop_off_type")
    private Integer drop_off_type;
    @Column(name="center_boarding")
    private Integer center_boarding;
    @Column(name="south_boarding")
    private Integer south_boarding;
    @Column(name="bikes_allowed")
    private Integer bikes_allowed;
    @Column(name="notice")
    private Integer notice;

    /***
     * Empty Constructor
     */
    public Stop() {
    }

    private Stop(Builder builder){
        this.trip_id = builder.trip_id;
        this.arrival_time = builder.arrival_time;
        this.departure_time = builder.departure_time;
        this.stop_id = builder.stop_id;
        this.stop_sequence = builder.stop_sequence;
        this.pickup_type = builder.pickup_type;
        this.drop_off_type = builder.drop_off_type;
        this.center_boarding = builder.center_boarding;
        this.south_boarding = builder.south_boarding;
        this.bikes_allowed = builder.bikes_allowed;
        this.notice = builder.notice;
    }

    /***
     * Builder Class
     */
    public static final class Builder{
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

        public Builder setTrip_id(String trip_id) {
            this.trip_id = trip_id;
            return this;
        }

        public Builder setArrival_time(String arrival_time) {
            this.arrival_time = arrival_time;
            return this;
        }

        public Builder setDeparture_time(String departure_time) {
            this.departure_time = departure_time;
            return this;
        }

        public Builder setStop_id(String stop_id) {
            this.stop_id = stop_id;
            return this;
        }

        public Builder setStop_sequence(Integer stop_sequence) {
            this.stop_sequence = stop_sequence;
            return this;
        }

        public Builder setPickup_type(Integer pickup_type) {
            this.pickup_type = pickup_type;
            return this;
        }

        public Builder setDrop_off_type(Integer drop_off_type) {
            this.drop_off_type = drop_off_type;
            return this;
        }

        public Builder setCenter_boarding(Integer center_boarding) {
            this.center_boarding = center_boarding;
            return this;
        }

        public Builder setSouth_boarding(Integer south_boarding) {
            this.south_boarding = south_boarding;
            return this;
        }

        public Builder setBikes_allowed(Integer bikes_allowed) {
            this.bikes_allowed = bikes_allowed;
            return this;
        }

        public Builder setNotice(Integer notice) {
            this.notice = notice;
            return this;
        }

        public Stop build(){
            return new Stop(this);
        }
    }

    @Override
    public String toString() {
        return "Stop{" +
                "trip_id='" + trip_id + '\'' +
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


    public String getTrip_id() {
        return trip_id;
    }

    public Stop setTrip_id(String trip_id) {
        this.trip_id = trip_id;
        return this;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public Stop setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
        return this;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public Stop setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
        return this;
    }

    public String getStop_id() {
        return stop_id;
    }

    public Stop setStop_id(String stop_id) {
        this.stop_id = stop_id;
        return this;
    }

    public Integer getStop_sequence() {
        return stop_sequence;
    }

    public Stop setStop_sequence(Integer stop_sequence) {
        this.stop_sequence = stop_sequence;
        return this;
    }

    public Integer getPickup_type() {
        return pickup_type;
    }

    public Stop setPickup_type(Integer pickup_type) {
        this.pickup_type = pickup_type;
        return this;
    }

    public Integer getDrop_off_type() {
        return drop_off_type;
    }

    public Stop setDrop_off_type(Integer drop_off_type) {
        this.drop_off_type = drop_off_type;
        return this;
    }

    public Integer getCenter_boarding() {
        return center_boarding;
    }

    public Stop setCenter_boarding(Integer center_boarding) {
        this.center_boarding = center_boarding;
        return this;
    }

    public Integer getSouth_boarding() {
        return south_boarding;
    }

    public Stop setSouth_boarding(Integer south_boarding) {
        this.south_boarding = south_boarding;
        return this;
    }

    public Integer getBikes_allowed() {
        return bikes_allowed;
    }

    public Stop setBikes_allowed(Integer bikes_allowed) {
        this.bikes_allowed = bikes_allowed;
        return this;
    }

    public Integer getNotice() {
        return notice;
    }

    public Stop setNotice(Integer notice) {
        this.notice = notice;
        return this;
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
