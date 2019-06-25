package com.stackroute.innovatorprofile.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class InnovatorProfile {
     @Id
     private String emailId;
     private String password;
     String name;
     String domain;
     List<String> subDomain;




     public InnovatorProfile(String emailId, String password, String name, String domain, List<String> subDomain) {
          this.emailId = emailId;
          this.password = password;
          this.name = name;
          this.domain = domain;
          this.subDomain = subDomain;

     }

     public InnovatorProfile() {
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

}
