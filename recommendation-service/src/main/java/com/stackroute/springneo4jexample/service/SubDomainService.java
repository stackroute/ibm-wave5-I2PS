package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.SubDomain;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface SubDomainService {
    Collection<SubDomain> getAll();

    SubDomain saved(SubDomain subDomain);
}
