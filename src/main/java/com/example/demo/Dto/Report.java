package com.example.demo.Dto;

public class Report {

    private Integer mobile_station_id;
    private float distance;
    private Long timestamp;

    public Integer getMobile_station_id() {
        return mobile_station_id;
    }

    public void setMobile_station_id(Integer mobile_station_id) {
        this.mobile_station_id = mobile_station_id;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
