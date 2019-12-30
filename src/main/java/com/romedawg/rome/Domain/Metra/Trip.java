package com.romedawg.rome.Domain.Metra;

import javax.persistence.*;

@Entity
@Table(name="trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="route_id")
    private String route_id;
    @Column(name="service_id")
    private String service_id;
    @Column(name="trip_id")
    private String trip_id;
    @Column(name="trip_headsign")
    private String trip_headsign;
    @Column(name="block_id")
    private String block_id;
    @Column(name="shape_id")
    private String shape_id;
    @Column(name="direction_id")
    private Integer direction_id;

    /***
     * Empty Constructor
     */
    public Trip() {
    }

    private Trip(Builder builder){
        this.route_id = builder.route_id;
        this.service_id = builder.service_id ;
        this.trip_id = builder.trip_id;
        this.trip_headsign = builder.trip_headsign;
        this.block_id = builder.block_id;
        this.shape_id = builder.shape_id;
        this.direction_id = builder.direction_id;
    }

    /***
     * Builder Class
     */
    public static final class Builder{
        private String route_id;
        private String service_id;
        private String trip_id;
        private String trip_headsign;
        private String block_id;
        private String shape_id;
        private Integer direction_id;

        public Builder setRoute_id(String route_id) {
            this.route_id = route_id;
            return this;
        }

        public Builder setService_id(String service_id) {
            this.service_id = service_id;
            return this;
        }

        public Builder setTrip_id(String trip_id) {
            this.trip_id = trip_id;
            return this;
        }

        public Builder setTrip_headsign(String trip_headsign) {
            this.trip_headsign = trip_headsign;
            return this;
        }

        public Builder setBlock_id(String block_id) {
            this.block_id = block_id;
            return this;
        }

        public Builder setShape_id(String shape_id) {
            this.shape_id = shape_id;
            return this;
        }

        public Builder setDirection_id(Integer direction_id) {
            this.direction_id = direction_id;
            return this;
        }

        public Trip build(){
            return new Trip(this);
        }
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

    public String getRoute_id() {
        return route_id;
    }

    public Trip setRoute_id(String route_id) {
        this.route_id = route_id;
        return this;
    }

    public String getService_id() {
        return service_id;
    }

    public Trip setService_id(String service_id) {
        this.service_id = service_id;
        return this;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public Trip setTrip_id(String trip_id) {
        this.trip_id = trip_id;
        return this;
    }

    public String getTrip_headsign() {
        return trip_headsign;
    }

    public Trip setTrip_headsign(String trip_headsign) {
        this.trip_headsign = trip_headsign;
        return this;
    }

    public String getBlock_id() {
        return block_id;
    }

    public Trip setBlock_id(String block_id) {
        this.block_id = block_id;
        return this;
    }

    public String getShape_id() {
        return shape_id;
    }

    public Trip setShape_id(String shape_id) {
        this.shape_id = shape_id;
        return this;
    }

    public Integer getDirection_id() {
        return direction_id;
    }

    public Trip setDirection_id(Integer direction_id) {
        this.direction_id = direction_id;
        return this;
    }
}


//{"route_id":"BNSF",
//        "service_id":"A1",
//        "trip_id":"BNSF_BN1200_V1_A",
//        "trip_headsign":"Chicago Union Station",
//        "block_id":"",
//        "shape_id":"BNSF_IB_1",
//        "direction_id":1}
