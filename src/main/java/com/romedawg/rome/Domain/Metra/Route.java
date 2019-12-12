package com.romedawg.rome.Domain.Metra;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name="route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "route_id")
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

    public Route() {
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", route_id='" + route_id + '\'' +
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

    public Long getId() {
        return id;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getRoute_short_name() {
        return route_short_name;
    }

    public void setRoute_short_name(String route_short_name) {
        this.route_short_name = route_short_name;
    }

    public String getRoute_long_name() {
        return route_long_name;
    }

    public void setRoute_long_name(String route_long_name) {
        this.route_long_name = route_long_name;
    }

    public String getRoute_desc() {
        return route_desc;
    }

    public void setRoute_desc(String route_desc) {
        this.route_desc = route_desc;
    }

    public String getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(String agency_id) {
        this.agency_id = agency_id;
    }

    public Integer getRoute_type() {
        return route_type;
    }

    public void setRoute_type(Integer route_type) {
        this.route_type = route_type;
    }

    public String getRoute_color() {
        return route_color;
    }

    public void setRoute_color(String route_color) {
        this.route_color = route_color;
    }

    public String getRoute_text_color() {
        return route_text_color;
    }

    public void setRoute_text_color(String route_text_color) {
        this.route_text_color = route_text_color;
    }

    public String getRoute_url() {
        return route_url;
    }

    public void setRoute_url(String route_url) {
        this.route_url = route_url;
    }
}
