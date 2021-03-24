package io.springboot2.x.dto;

import java.io.Serializable;
import java.util.List;

public class NetflixUserDTO implements Serializable {

    private String phoneNor;
    private String userName;
    private String email;
    private String planId;

    private NetflixPlanDTO currentPlan;
    private List<NetflixDevicesDTO> devicesConnected;

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
