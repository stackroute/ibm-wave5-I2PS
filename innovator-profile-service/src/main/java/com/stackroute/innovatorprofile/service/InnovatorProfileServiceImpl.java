package com.stackroute.innovatorprofile.service;

import com.stackroute.innovatorprofile.domain.InnovatorProfile;
import com.stackroute.innovatorprofile.repository.InnovatorProfileRespository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InnovatorProfileServiceImpl implements InnovatorProfileService
{
    InnovatorProfileRespository innovatorProfileRespository;
    @Autowired
   private RabbitTemplate rabbitTemplate;
  @Value("${javainuse.rabbitmq.exchange}")
  String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
   private String routingkey;


    @Autowired
    public InnovatorProfileServiceImpl(InnovatorProfileRespository innovatorProfileRespository) {
        this.innovatorProfileRespository = innovatorProfileRespository;
    }

    @Override
    public InnovatorProfile saveInnovatorProfile(InnovatorProfile innovatorProfile) {
        return innovatorProfileRespository.save(innovatorProfile);
    }


    public void send(InnovatorProfile innovatorProfile) {
        rabbitTemplate.convertAndSend(exchange, routingkey, innovatorProfile);
        System.out.println("Send msg = " + innovatorProfile);
    }
}
