package com.stackroute.springneo4jexample.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@NodeEntity

public class SubDomain {
    @Id
    private Long id;
    private String subDomainName;


    public SubDomain() {
    }

    public SubDomain(Long id, String subDomainName) {
        this.id = id;
        this.subDomainName = subDomainName;
    }

    public Long getId() {
        return id;
    }

    public String getSubDomainName() {
        return subDomainName;
    }
}



