package com.pack.model;

import java.io.Serializable;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class NetflixUserDTO implements Serializable {

    private String phoneNor;
    @NotEmpty(message = "User name is required")
    private String userName;
    @NotEmpty(message = "Email is required")
    @Email(message = "Enter valid mail")
    private String email;
    @NotEmpty(message = "Plan id is required")
    private String planId;

    private NetflixPlanDTO currentPlan;
    private List<NetflixDevicesDTO> devicesConnected;
    private List<NetflixPlanDTO> plansList;
    
    
    public List<NetflixPlanDTO> getPlansList() {
		return plansList;
	}

	public void setPlansList(List<NetflixPlanDTO> plansList) {
		this.plansList = plansList;
	}

	public String getPhoneNor() {
        return phoneNor;
    }

    public void setPhoneNor(String phoneNor) {
        this.phoneNor = phoneNor;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public NetflixPlanDTO getCurrentPlan() {
        return currentPlan;
    }

    public void setCurrentPlan(NetflixPlanDTO currentPlan) {
        this.currentPlan = currentPlan;
    }

    public List<NetflixDevicesDTO> getDevicesConnected() {
        return devicesConnected;
    }

    public void setDevicesConnected(List<NetflixDevicesDTO> devicesConnected) {
        this.devicesConnected = devicesConnected;
    }
}
