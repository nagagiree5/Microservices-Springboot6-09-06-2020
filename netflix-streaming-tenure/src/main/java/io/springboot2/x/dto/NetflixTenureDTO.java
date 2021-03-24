package io.springboot2.x.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Date;


public class NetflixTenureDTO {

    private Integer id ;
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message="Mobile number is invalid")
    private String mobile ;
    @NotEmpty(message = "Email is required")
    @Email(message = "Enter valid mail address")
    private String gmail ;
    @NotEmpty(message = "Plan is required")
    private String plan  ;
    @Past(message = "Must be past date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start ;
    @Future(message = "Must be future date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date  stop   ;
    @NotEmpty(message = "Duration In Hrs is required")
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
