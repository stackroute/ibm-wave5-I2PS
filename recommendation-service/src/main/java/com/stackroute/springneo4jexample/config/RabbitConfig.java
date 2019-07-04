package com.stackroute.springneo4jexample.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${serviceNeo4j.queue}")
    String serviceNeo4j;

    @Value("${serviceProvider.exchange}")
    String servicePExchange;

    @Value("${serviceProvider.routingkey}")
    String servicePRoutingkey;

    @Bean
    Queue serviceNeo4jQueue() {
        return new Queue(serviceNeo4j,true);

    }
    @Bean
    Exchange servicePExchange(){
        return ExchangeBuilder.topicExchange(servicePExchange).durable(true).build();
    }
    @Bean
    Binding innovatorBinding(){
        //this is the traditional way of binding
//        return new Binding(MY_QUEUE, Binding.DestinationType.QUEUE,"myTopicExchange","topic",null);
        //more declarative way of binding
        return BindingBuilder.bind(serviceNeo4jQueue()).to(servicePExchange()).with(servicePRoutingkey).noargs();
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