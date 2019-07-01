package com.stackroute.serviceproviderprofileservice.service;

import com.stackroute.serviceproviderprofileservice.domain.ServiceProvider;
import com.stackroute.serviceproviderprofileservice.repository.ServiceProviderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService
{
    ServiceProviderRepository serviceProviderRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${serviceProvider.exchange}")
    String servicePExchange;

    @Value("${serviceProvider.routingkey}")
    String servicePRoutingkey;


    @Autowired
    public ServiceProviderServiceImpl(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }

    @Override
    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public List<ServiceProvider> getServiceProvider() {
        return serviceProviderRepository.findAll();
    }


    public void send(ServiceProvider serviceProvider) {
        rabbitTemplate.convertAndSend(servicePExchange, servicePRoutingkey, serviceProvider);
        System.out.println("Send msg = " + serviceProvider);
    }
}
