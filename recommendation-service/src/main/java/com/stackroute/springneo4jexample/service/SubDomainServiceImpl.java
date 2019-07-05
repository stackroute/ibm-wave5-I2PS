package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.SubDomain;
import com.stackroute.springneo4jexample.repository.SubDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class SubDomainServiceImpl implements SubDomainService {
    @Autowired
    SubDomainRepository subDomainRepository;

    @Override
    public Collection<SubDomain> getAll() {
        return subDomainRepository.getAllNode();
    }

    @Override
    public SubDomain saveSubDomain(Long id, String subDomainName) {
        SubDomain savedSubDomain=null;

        savedSubDomain=subDomainRepository.createNode(id,subDomainName);
        return savedSubDomain;
    }

    @Override
    public SubDomain ideaRecommend(String name) {
        return subDomainRepository.ideaRecommend(name);
    }

    @Override
    public SubDomain saved(SubDomain subDomain) {
        return subDomainRepository.save(subDomain);
    }

    @Override
    public SubDomain createRelationship(String subDomain, String subDomainName) {
        return subDomainRepository.relation(subDomain,subDomainName);
    }

    @Override
    public SubDomain ideaRelationship(String subDomain, String subDomainName) {
        return subDomainRepository.ideaRelationship(subDomain,subDomainName);
    }

    @Override
    public SubDomain updateUser(SubDomain subDomain) {
        return subDomainRepository.save(subDomain);
    }
}
