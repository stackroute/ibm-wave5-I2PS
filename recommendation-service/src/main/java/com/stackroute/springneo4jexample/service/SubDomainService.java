package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.SubDomain;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface SubDomainService {
    Collection<SubDomain> getAll();

  

    SubDomain createRelationship(String subDomain, String subDomainName);

    SubDomain ideaRelationship(String subDomain, String subDomainName);

    SubDomain updateUser(SubDomain subDomain);

    SubDomain saveSubDomain(Long id, String subDomainName);

    SubDomain ideaRecommend(String name);

    SubDomain saved(SubDomain subDomain);
}
