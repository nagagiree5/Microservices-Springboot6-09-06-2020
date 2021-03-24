package com.pack.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class RegisterNetflixDTO implements Serializable {
	   @NotEmpty(message = "Phone number is required")
	    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	            message="Mobile number is invalid")
    private String phoneNor;
	   @NotEmpty(message = "User name is required")
    private String userName;
	    @NotEmpty(message = "Password is required")
    private String password;
	    @NotEmpty(message = "Email is required")
	    @Email(message = "Enter valid mail")
    private String email;
	    @NotEmpty(message = "Plan id is required")
	    
    private String planId;

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
