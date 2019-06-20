package com.stackroute;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/* @SpringBootApplication -- > Either this or the below mentioned three annotations... */

//@Component
//@Configuration
//@EnableAutoConfiguration

@SpringBootApplication

public class UserRegistrationServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserRegistrationServiceApplication.class, args);
	}


	@Bean
	ConnectionFactory connectionFactory(){
		//we want connection to be stable,so that we needn't close or open connection
		CachingConnectionFactory cachingConnectionFactory =new CachingConnectionFactory("localhost");
		cachingConnectionFactory.setUsername("guest");
		cachingConnectionFactory.setPassword("guest");
		return cachingConnectionFactory;
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}

	}


