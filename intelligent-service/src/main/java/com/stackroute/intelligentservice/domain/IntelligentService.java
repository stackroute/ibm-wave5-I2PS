package com.stackroute.intelligentservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Document (collection = "intelligentService")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class IntelligentService {
    @Id
    private  String roleId;
    private String role;
    private List<ServiceProvider> serviceProvider = new ArrayList<>();

    @Override
    public String toString() {
        return "IntelligentService{" +
                "roleId='" + roleId + '\'' +
                ", role='" + role + '\'' +
                ", serviceProvider=" + serviceProvider +
                '}';
    }
}
