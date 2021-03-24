package io.springboot2.x.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="NETFLIXPLAN")
public class NetflixPlan {

    @Id
    @Column(length = 35)
    private String planId;
    @Column(length = 35)
    private String planName;
    @Column(length = 55)
    private String pricePerMonth;
    @Column(length = 225)
    private String featuresProvide;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(String pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getFeaturesProvide() {
        return featuresProvide;
    }

    public void setFeaturesProvide(String featuresProvide) {
        this.featuresProvide = featuresProvide;
    }
}
