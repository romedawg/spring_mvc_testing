package com.romedawg.rome.Domain;

public class StationServices {

    private Integer id;
    private String service_type;
    private String bikes_availability;
    private String docks_availability;
    private String name;
    private String description;
    private String schedule_description;
    private String link_for_more_info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getBikes_availability() {
        return bikes_availability;
    }

    public void setBikes_availability(String bikes_availability) {
        this.bikes_availability = bikes_availability;
    }

    public String getDocks_availability() {
        return docks_availability;
    }

    public void setDocks_availability(String docks_availability) {
        this.docks_availability = docks_availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchedule_description() {
        return schedule_description;
    }

    public void setSchedule_description(String schedule_description) {
        this.schedule_description = schedule_description;
    }

    public String getLink_for_more_info() {
        return link_for_more_info;
    }

    public void setLink_for_more_info(String link_for_more_info) {
        this.link_for_more_info = link_for_more_info;
    }
}

// Data Structure
//        "eightd_station_services":[{"id":"67ac7df5-d3da-4867-b7a1-cb70bb339671",
//        "service_type":"ATTENDED_SERVICE",
//        "bikes_availability":"UNLIMITED",
//        "docks_availability":"UNLIMITED",
//        "name":"Valet",
//        "description":"Divvy staff are here to load the station with extra bikes and make sure that there’s a space for you to dock your bike.",
//        "schedule_description":"Monday-Friday; 6:00am-10:30am & 3:30pm-8:00pm",
//        "link_for_more_info":"https://www.divvybikes.com/valet"}],