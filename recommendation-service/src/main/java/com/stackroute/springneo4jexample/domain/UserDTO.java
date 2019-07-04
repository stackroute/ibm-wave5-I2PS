package com.stackroute.springneo4jexample.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {


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
}