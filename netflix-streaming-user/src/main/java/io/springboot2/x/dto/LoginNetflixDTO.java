package io.springboot2.x.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class LoginNetflixDTO implements Serializable {
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message="Mobile number is invalid")
    private String phoneNor;
    @NotEmpty(message = "Password is required")
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
