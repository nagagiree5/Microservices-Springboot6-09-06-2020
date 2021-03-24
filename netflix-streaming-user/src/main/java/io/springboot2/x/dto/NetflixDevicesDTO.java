package io.springboot2.x.dto;

import java.io.Serializable;

public class NetflixDevicesDTO implements Serializable {
    private String device ;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
