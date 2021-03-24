package io.springboot2.x.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="NETFLIXDEVICE")
public class NetflixDevice {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Integer id ;
    @Column(length =25)
    private String mobile ;
    @Column(length =35)
    private String device ;

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

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
