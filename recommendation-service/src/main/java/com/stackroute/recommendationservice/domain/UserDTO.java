package com.stackroute.recommendationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
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
    Collection<Object> subDomain;
    String role;
    Collection<Object> skills;
    String about;
    String experience;
    Double chargePerHour;
}