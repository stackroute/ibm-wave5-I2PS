package com.stackroute.serviceproviderprofileservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceProvider {
     @Id
     private String emailId;
     private String password;
     String name;
     String domain;
     List<String> subDomain;
     String role;
     ArrayList<SkillsAndExperience> skillsAndExperiences;
     String about;
     Double chargePerHour;
     List<String> certifications;




}
