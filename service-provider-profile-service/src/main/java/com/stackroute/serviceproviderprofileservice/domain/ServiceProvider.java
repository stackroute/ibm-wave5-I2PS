package com.stackroute.serviceproviderprofileservice.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.util.List;

@Document
public class ServiceProvider {
     @Id
     private String emailId;
     private String password;
     String name;
     String domain;
     List<String> subDomain;
     String role;
     List<String> skills;
     String about;
     String experience;
     Double chargePerHour;
     List<String> certifications;



     public ServiceProvider(String emailId, String password, String name, String domain, List<String> subDomain, String role, List<String> skills, String about, String experience, Double chargePerHour, List<String> certifications) {
          this.emailId = emailId;
          this.password = password;
          this.name = name;
          this.domain = domain;
          this.subDomain = subDomain;
          this.role = role;
          this.skills = skills;
          this.about = about;
          this.experience = experience;
          this.chargePerHour = chargePerHour;
          this.certifications = certifications;
     }

     public ServiceProvider() {
     }

     public String getEmailId() {
          return emailId;
     }

     public void setEmailId(String emailId) {
          this.emailId = emailId;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getDomain() {
          return domain;
     }

     public void setDomain(String domain) {
          this.domain = domain;
     }

     public List<String> getSubDomain() {
          return subDomain;
     }

     public void setSubDomain(List<String> subDomain) {
          this.subDomain = subDomain;
     }

     public String getRole() {
          return role;
     }

     public void setRole(String role) {
          this.role = role;
     }

     public List<String> getSkills() {
          return skills;
     }

     public void setSkills(List<String> skills) {
          this.skills = skills;
     }

     public String getAbout() {
          return about;
     }

     public void setAbout(String about) {
          this.about = about;
     }

     public String getExperience() {
          return experience;
     }

     public void setExperience(String experience) {
          this.experience = experience;
     }

     public Double getChargePerHour() {
          return chargePerHour;
     }

     public void setChargePerHour(Double chargePerHour) {
          this.chargePerHour = chargePerHour;
     }

     public List<String> getCertifications() {
          return certifications;
     }

     public void setCertifications(List<String> certifications) {
          this.certifications = certifications;
     }
}
