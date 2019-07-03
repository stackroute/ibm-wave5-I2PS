package com.stackroute.intelligentservice.service;

import com.stackroute.intelligentservice.domain.IntelligentService;
import com.stackroute.intelligentservice.repository.IntelligentServiceRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntelligentServiceImpl implements IntelligentSeviceInterface {


    @Autowired
    IntelligentServiceRepository intelligentServiceRepository;



    @RabbitListener(queues = "${serviceProvider.queue}")
    public IntelligentService recievedMessageFromServiceProvider(IntelligentService intelligentService) {
//        intelligentServiceRepository.save(intelligentService);
        if (intelligentServiceRepository.existsById(intelligentService.getRoleId()))
        {
            update(intelligentService);

        }
        else
        {
            return intelligentServiceRepository.save(intelligentService);
        }
        System.out.println("Recieved Message From serviceProvider:" + intelligentService.toString());
        return null;

    }

//    @Override
//    public IntelligentService createOrUpdate(IntelligentService intelligentService) {
//        if (intelligentServiceRepository.existsById(intelligentService.getRoleId()))
//        {
//            update(intelligentService);
//
//        }
//        else
//        {
//            return intelligentServiceRepository.save(intelligentService);
//        }
//    }
//
    private IntelligentService update(IntelligentService intelligentService) {

        IntelligentService intelligentServiceInUpdate= new IntelligentService();
        if (intelligentServiceRepository.existsById(intelligentService.getRoleId())) {

            System.out.println("role exists");
            intelligentServiceInUpdate=intelligentServiceRepository.save(intelligentService);

        }

        return intelligentServiceInUpdate;

    }

//    @Override
//    public Iterable<IntelligentService> getByRole(int roleId) {
//        return intelligentServiceRepository.findAllById(roleId);
//    }
}
