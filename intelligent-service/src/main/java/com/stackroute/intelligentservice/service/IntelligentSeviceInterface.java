package com.stackroute.intelligentservice.service;

import com.stackroute.intelligentservice.domain.IntelligentService;

import java.util.Collection;

public interface IntelligentSeviceInterface {
    public IntelligentService create(IntelligentService intelligentService);
    public IntelligentService update(String role);
    public Collection<IntelligentService> getByRole(String role);
}
