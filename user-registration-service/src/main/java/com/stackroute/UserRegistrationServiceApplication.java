package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* @SpringBootApplication -- > Either this or the below mentioned three annotations... */

//@Component
//@Configuration
//@EnableAutoConfiguration

@SpringBootApplication

public class UserRegistrationServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserRegistrationServiceApplication.class, args);
	}

}
