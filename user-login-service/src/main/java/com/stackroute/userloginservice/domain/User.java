package com.stackroute.userloginservice.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    @Id
    private String userName;
    private String password;
    private String role;

}