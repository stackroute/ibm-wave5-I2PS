package com.stackroute.serviceproviderprofileservice.controller;

import com.stackroute.serviceproviderprofileservice.domain.ServiceProvider;
import com.stackroute.serviceproviderprofileservice.service.ServiceProviderService;
import com.stackroute.serviceproviderprofileservice.service.ServiceProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/v1")
public class ServiceProviderController
{
    private ServiceProviderServiceImpl serviceProviderServiceimpl;

    @Autowired
    public ServiceProviderController(ServiceProviderServiceImpl serviceProviderServiceimpl) {
        this.serviceProviderServiceimpl = serviceProviderServiceimpl;
    }
//method to save a service provider profile
    @PostMapping("/serviceprovider")
    public ResponseEntity<?> saveServiceProvider(@RequestBody ServiceProvider serviceProvider)
    {
        serviceProviderServiceimpl.send(serviceProvider);
        return new ResponseEntity<ServiceProvider>(serviceProviderServiceimpl.saveServiceProvider(serviceProvider), HttpStatus.CREATED);
    }

    //method to get all service provider profiles
    @GetMapping("/serviceproviders")
       public ResponseEntity<?> getserviceProviders()
        {
           return  new ResponseEntity<List<ServiceProvider>>(serviceProviderServiceimpl.getServiceProvider(),HttpStatus.OK);
        }
    }

