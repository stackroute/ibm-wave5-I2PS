package com.stackroute.intelligentservice.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;


@Document (collection = "intelligentService")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntelligentService {

    private String role;
    private List<ServiceProvider> serviceProvider = new ArrayList<>();

    @Override
    public String toString() {
        return "IntelligentService{" +
                "role='" + role + '\'' +
                ", serviceProvider=" + serviceProvider +
                '}';
    }
}
