package com.stackroute.intelligentservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document (collection = "intelligentService")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntelligentService {

    @Id
    private String roleId;
    private String role;
    private List<ServiceProvider> serviceProviders = new ArrayList<>();
    private List<SkillsAndExperience> skillsAndExperiences=new ArrayList<>();

    @Override
    public String toString() {
        return "IntelligentService{" +
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                ", serviceProviders=" + serviceProviders +
                '}';
    }
}
