package com.stackroute.intelligentservice.service;

import com.stackroute.intelligentservice.domain.IntelligentService;
import com.stackroute.intelligentservice.domain.ServiceProvider;
import com.stackroute.intelligentservice.repository.IntelligentServiceRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntelligentServiceImpl implements IntelligentSeviceInterface {

    private IntelligentServiceRepository intelligentServiceRepository;
    private IntelligentService intelligentService;

    @Autowired
    public IntelligentServiceImpl(IntelligentServiceRepository intelligentServiceRepository, IntelligentService intelligentService) {
        this.intelligentServiceRepository = intelligentServiceRepository;
        this.intelligentService = intelligentService;
    }

    @RabbitListener(queues = "${intelligent.queue}")
    public IntelligentService recievedMessageFromServiceProvider(ServiceProvider serviceProvider) {
        System.out.println(serviceProvider.toString());
            String role1= serviceProvider.getRole();
        System.out.println(role1);
            IntelligentService retrievedIntelligentService = intelligentServiceRepository.findByRole(role1);
        System.out.println(retrievedIntelligentService);

        if (retrievedIntelligentService!=null)
        {
            List<ServiceProvider> serviceProviderList=retrievedIntelligentService.getServiceProvider();
            serviceProviderList.add(serviceProvider);
            intelligentServiceRepository.save(retrievedIntelligentService);

        }
        else
        {
            String role = serviceProvider.getRole();
            intelligentService.setRole(role);
            List<ServiceProvider> serviceProviders = new ArrayList<>();
            serviceProviders.add(serviceProvider);
            intelligentService.setServiceProvider(serviceProviders);
            intelligentServiceRepository.save(intelligentService);

        }
        System.out.println("Recieved Message From serviceProvider:" + serviceProvider.toString());
        return null;

    }

    @Override
    public IntelligentService getByRole(String role) {
        return intelligentServiceRepository.findByRole(role);
    }
}
