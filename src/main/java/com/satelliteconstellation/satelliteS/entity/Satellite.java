package com.satelliteconstellation.satelliteS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import java.util.Date;

@Entity
public class Satellite {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long satelliteId;
    private String satelliteName;
    private String country;
    private String launchDate;
    private String status;

    public long getSatelliteId() {
        return satelliteId;
    }
    public void setSatelliteId(long satelliteId) {
        this.satelliteId = satelliteId;
    }
    public String getSatelliteName() {
        return satelliteName;
    }
    public void setSatelliteName(String satelliteName) {
        this.satelliteName = satelliteName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getLaunchDate() {
        return launchDate;
    }
    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
