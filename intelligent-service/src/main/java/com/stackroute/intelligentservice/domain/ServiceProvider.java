package com.stackroute.intelligentservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Document
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
    List<String> subDomain;
    String role;
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
                ", about='" + about + '\'' +
                ", chargePerHour=" + chargePerHour +
                '}';
    }
}
