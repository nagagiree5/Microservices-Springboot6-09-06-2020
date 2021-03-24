package io.springboot2.x.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class NetflixPlanUpdateDTO {
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message="Mobile number is invalid")
    private String phoneNor;
    @NotEmpty(message = "PLAN ID is required")
    private String planId;

    public String getPhoneNor() {
        return phoneNor;
    }

    public void setPhoneNor(String phoneNor) {
        this.phoneNor = phoneNor;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }
}
