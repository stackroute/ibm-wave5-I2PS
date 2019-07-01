package com.stackroute.innovatorprofile.service;

import com.stackroute.innovatorprofile.domain.InnovatorProfile;
import com.stackroute.innovatorprofile.exception.EmailIdAlreadyExistsException;
import com.stackroute.innovatorprofile.repository.InnovatorProfileRespository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InnovatorProfileServiceImpl implements InnovatorProfileService
{
    InnovatorProfileRespository innovatorProfileRespository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${innovator.exchange}")
    String innovatorExchange;

    @Value("${innovator.routingkey}")
    private String innovatorRoutingKey;

    @Autowired
    public InnovatorProfileServiceImpl(InnovatorProfileRespository innovatorProfileRespository) {
        this.innovatorProfileRespository = innovatorProfileRespository;
    }

    @Override
    public InnovatorProfile saveInnovatorProfile(InnovatorProfile innovatorProfile) throws EmailIdAlreadyExistsException {
        if(innovatorProfileRespository.existsById(innovatorProfile.getEmailId()))
        {
            throw new EmailIdAlreadyExistsException("EmailId Already Exists");
        }
        InnovatorProfile savedInnovatorProfile=innovatorProfileRespository.save(innovatorProfile);
        if(savedInnovatorProfile == null)
        {
            throw new EmailIdAlreadyExistsException("EmailId Already Exists");
        }

        return savedInnovatorProfile;
        //return innovatorProfileRespository.save(innovatorProfile);
    }

    @Override
    public List<InnovatorProfile> getInnovatorProfile() {
        return innovatorProfileRespository.findAll();
    }


    public void send(InnovatorProfile innovatorProfile) {
        rabbitTemplate.convertAndSend(innovatorExchange, innovatorRoutingKey, innovatorProfile);
        System.out.println("Send msg = " + innovatorProfile);
    }
}
