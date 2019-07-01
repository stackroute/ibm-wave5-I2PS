package com.stackroute.intelligentservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    @Value("${recommendationService.queue}")
    String recommendationQueueName;

    @Value("${recommendationService.exchange}")
    String recommendationServiceExchange;

    @Value("${recommendationService.routingkey}")
    private String recommendationServiceRoutingKey;


    @Value("${ideaHubService.queue}")
    String ideaHubServiceQueueName;

    @Value("${ideaHubService.exchange}")
    String ideaHubServiceExchange;

    @Value("${ideaHubService.routingkey}")
    private String ideaHubServiceRoutingKey;

    @Bean
     Queue recommendationServiceQueue()
    {
        return new Queue(recommendationQueueName,true);

    }
    @Bean
    Exchange recommendationServiceExchange(){
        return ExchangeBuilder.topicExchange(recommendationServiceExchange).durable(true).build();
    }
    @Bean
    Binding recomendationServiceBinding(){
        return BindingBuilder
                .bind(recommendationServiceQueue())
                .to(recommendationServiceExchange())
                .with("recommendationServiceRoutingKey")
                .noargs();
    }


    @Bean
    Queue ideaHubServiceQueue()
    {

        return new Queue(ideaHubServiceQueueName,true);
    }
    @Bean
    Exchange ideaHubServiceExchange(){
        return ExchangeBuilder.topicExchange(ideaHubServiceExchange).durable(true).build();
    }
    @Bean
    Binding ideaHubServiceBinding(){
        return BindingBuilder
                .bind(ideaHubServiceQueue())
                .to(ideaHubServiceExchange())
                .with(ideaHubServiceRoutingKey)
                .noargs();
    }


    @Bean
    ConnectionFactory connectionFactory(){    //we want connection to be stable,so that we needn't close or open connection

        CachingConnectionFactory cachingConnectionFactory =new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {  //for decrypting the message recived by producer
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
