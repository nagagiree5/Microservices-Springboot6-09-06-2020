package io.springboot2.x.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NETFLIXUSER")
public class NetflixUser {

    @Id
    private String phoneNor;
    @Column(length = 25)
    private String userName;
    @Column(length = 225)
    private String password;
    @Column(length = 35)
    private String email;
    @Column(length = 25)
    private String planId;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
