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


    @Autowired
    IntelligentServiceRepository intelligentServiceRepository;


    @RabbitListener(queues = "${intelligent.queue}")
    public IntelligentService recievedMessageFromServiceProvider(ServiceProvider serviceProvider) {
        System.out.println(serviceProvider.toString());
            IntelligentService intelligentService = intelligentServiceRepository.findByRole(serviceProvider.getRole());
        if (intelligentService!=null)
        {
            List<ServiceProvider> serviceProviderList=intelligentService.getServiceProvider();
            serviceProviderList.add(serviceProvider);
            intelligentServiceRepository.save(intelligentService);

        }
        else
        {
            intelligentService.setRole(serviceProvider.getRole());
            List<ServiceProvider> serviceProviders = new ArrayList<>();
            serviceProviders.add(serviceProvider);
            intelligentService.setServiceProvider(serviceProviders);
            intelligentServiceRepository.save(intelligentService);

        }
        System.out.println("Recieved Message From serviceProvider:" + intelligentService.toString());
        return null;

    }

//    @Override
//    public Iterable<IntelligentService> getByRole(int roleId) {
//        return intelligentServiceRepository.findAllById(roleId);
//    }
}
