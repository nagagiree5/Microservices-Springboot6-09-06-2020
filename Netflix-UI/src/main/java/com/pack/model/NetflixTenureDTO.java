package com.pack.model;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;


public class NetflixTenureDTO {
   
    private Integer id ;
    private String mobile ;
    private String gmail ;
    private String plan  ;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start ;
  
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date  stop   ;
    private String durationInHrs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
    }

    public String getDurationInHrs() {
        return durationInHrs;
    }

    public void setDurationInHrs(String durationInHrs) {
        this.durationInHrs = durationInHrs;
    }
}
