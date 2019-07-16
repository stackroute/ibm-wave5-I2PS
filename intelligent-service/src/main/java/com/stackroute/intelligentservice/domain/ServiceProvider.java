package com.stackroute.intelligentservice.domain;

import lombok.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceProvider {

    private String emailId;
    private String password;
    String name;
    String domain;
    ArrayList<String> subDomain;
    String role;
    ArrayList<String> skills;     //array list reference of SKillsAndExperiance
    String about;
    BigDecimal chargePerHour;

    @Override
    public String toString() {
        return "ServiceProvider{" +
                "emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", subDomain=" + subDomain +
                ", role='" + role + '\'' +
                ", skills=" + skills +
                ", about='" + about + '\'' +
                ", chargePerHour=" + chargePerHour +
                '}';
    }
}
