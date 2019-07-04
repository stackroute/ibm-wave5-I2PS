package com.stackroute.serviceproviderprofileservice.service;


import com.stackroute.serviceproviderprofileservice.domain.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {
    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider);
    public List<ServiceProvider> getServiceProvider();
    public ServiceProvider getByEmailId(String emailId);
}
