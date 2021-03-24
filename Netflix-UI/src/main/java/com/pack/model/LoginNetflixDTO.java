package com.pack.model;

import java.io.Serializable;

public class LoginNetflixDTO implements Serializable {

    private String phoneNor;
    private String password;

    public String getPhoneNor() {
        return phoneNor;
    }

    public void setPhoneNor(String phoneNor) {
        this.phoneNor = phoneNor;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
