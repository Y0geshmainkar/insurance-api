package com.yogesh.insuranceapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;
    private String holderName;
    private String type;       // LIFE, HEALTH, AUTO
    private Double premium;
    private String status;     // ACTIVE, INACTIVE

    public Policy() {}

    public Policy(String policyNumber, String holderName, String type, Double premium, String status) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.type = type;
        this.premium = premium;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Double getPremium() { return premium; }
    public void setPremium(Double premium) { this.premium = premium; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
