package com.example.demo.Dto;

import java.util.List;

public class BaseStaionResult {

    public Integer base_station_id;
    public List<Report> reports;

    public Integer getBase_station_id() {
        return base_station_id;
    }

    public void setBase_station_id(Integer base_station_id) {
        this.base_station_id = base_station_id;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
