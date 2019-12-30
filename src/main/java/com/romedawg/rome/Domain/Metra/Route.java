package com.romedawg.rome.Domain.Metra;

import javax.persistence.*;

@Entity
@Table(name="route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "route_id", unique = true)
    private String route_id;

    @Column(name = "route_short_name")
    private String route_short_name;

    @Column(name = "route_long_name")
    private String route_long_name;

    @Column(name = "route_desc")
    private String route_desc;

    @Column(name = "agency_id")
    private String agency_id;

    @Column(name = "route_type")
    private Integer route_type;

    @Column(name = "route_color")
    private String route_color;

    @Column(name = "route_text_color")
    private String route_text_color;

    @Column(name = "route_url")
    private String route_url;

    /***
     * Constructor.
     */
    public Route() {
        // empty constructor
    }

    private Route(Builder builder){
        this.route_id = builder.route_id;
        this.route_short_name = builder.route_short_name;
        this.route_long_name =  builder.route_long_name;
        this.route_desc = builder.route_desc;
        this.agency_id = builder.agency_id;
        this.route_type = builder.route_type;
        this.route_color = builder.route_color;
        this.route_text_color = builder.route_text_color;
        this.route_url = builder.route_url;
    }

    /***
     * Builder class.
     */
    public static final class Builder {
        private String route_id;
        private String route_short_name;
        private String route_long_name;
        private String route_desc;
        private String agency_id;
        private Integer route_type;
        private String route_color;
        private String route_text_color;
        private String route_url;

        public Builder setRoute_id(String route_id) {
            this.route_id = route_id;
            return this;
        }

        public Builder setRoute_short_name(String route_short_name) {
            this.route_short_name = route_short_name;
            return this;
        }

        public Builder setRoute_long_name(String route_long_name) {
            this.route_long_name = route_long_name;
            return this;
        }

        public Builder setRoute_desc(String route_desc) {
            this.route_desc = route_desc;
            return this;
        }

        public Builder setAgency_id(String agency_id) {
            this.agency_id = agency_id;
            return this;
        }

        public Builder setRoute_type(Integer route_type) {
            this.route_type = route_type;
            return this;

        }

        public Builder setRoute_color(String route_color) {
            this.route_color = route_color;
            return this;
        }

        public Builder setRoute_text_color(String route_text_color) {
            this.route_text_color = route_text_color;
            return this;
        }

        public Builder setRoute_url(String route_url) {
            this.route_url = route_url;
            return this;
        }

        public Route build(){
            return new Route(this);
        }
    }

    @Override
    public String toString() {
        return "Route{" +
                "route_id='" + route_id + '\'' +
                ", route_short_name='" + route_short_name + '\'' +
                ", route_long_name='" + route_long_name + '\'' +
                ", route_desc='" + route_desc + '\'' +
                ", agency_id='" + agency_id + '\'' +
                ", route_type=" + route_type +
                ", route_color='" + route_color + '\'' +
                ", route_text_color='" + route_text_color + '\'' +
                ", route_url='" + route_url + '\'' +
                '}';
    }

    public String getRoute_id() {
        return route_id;
    }

    public Route setRoute_id(String route_id) {
        this.route_id = route_id;
        return this;
    }

    public String getRoute_short_name() {
        return route_short_name;
    }

    public Route setRoute_short_name(String route_short_name) {
        this.route_short_name = route_short_name;
        return this;
    }

    public String getRoute_long_name() {
        return route_long_name;
    }

    public Route setRoute_long_name(String route_long_name) {
        this.route_long_name = route_long_name;
        return this;
    }

    public String getRoute_desc() {
        return route_desc;
    }

    public Route setRoute_desc(String route_desc) {
        this.route_desc = route_desc;
        return this;
    }

    public String getAgency_id() {
        return agency_id;
    }

    public Route setAgency_id(String agency_id) {
        this.agency_id = agency_id;
        return this;
    }

    public Integer getRoute_type() {
        return route_type;
    }

    public Route setRoute_type(Integer route_type) {
        this.route_type = route_type;
        return this;
    }

    public String getRoute_color() {
        return route_color;
    }

    public Route setRoute_color(String route_color) {
        this.route_color = route_color;
        return this;
    }

    public String getRoute_text_color() {
        return route_text_color;
    }

    public Route setRoute_text_color(String route_text_color) {
        this.route_text_color = route_text_color;
        return this;
    }

    public String getRoute_url() {
        return route_url;
    }

    public Route setRoute_url(String route_url) {
        this.route_url = route_url;
        return this;
    }

}
