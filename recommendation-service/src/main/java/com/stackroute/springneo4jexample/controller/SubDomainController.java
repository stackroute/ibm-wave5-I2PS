package com.stackroute.springneo4jexample.controller;

import com.stackroute.springneo4jexample.model.SubDomain;
import com.stackroute.springneo4jexample.service.SubDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/sub")
public class SubDomainController {

    @Autowired
    public SubDomainService subDomainService;

    @GetMapping("/getall")
    public Collection<SubDomain> getAll() {

        return subDomainService.getAll();
    }

    @PostMapping("/save")
    public SubDomain saveSubDomain(@RequestBody SubDomain subDomain) {

        return subDomainService.saveSubDomain(subDomain.getId(),subDomain.getSubDomainName());
    }
    @PostMapping("/newRelationship/{subDomain}/{subDomainName}")
    public SubDomain relationship(@PathVariable String subDomain, @PathVariable String subDomainName) {
       SubDomain subDomain1 = subDomainService.createRelationship(subDomain, subDomainName);
        return subDomain1;
    }

    @PostMapping("/map/{subDomain}/{subDomainName}")
    public SubDomain ideaRelationship(@PathVariable String subDomain, @PathVariable String subDomainName) {
        SubDomain subDomain2= subDomainService.ideaRelationship(subDomain, subDomainName);
        return subDomain2;
    }
    @PutMapping("/{subDomainName}")
    public SubDomain updateSubDomain(@RequestBody SubDomain subDomain){
        return subDomainService.updateUser(subDomain);
    }

    @PostMapping("/recommend/{name}")
    public SubDomain ideaRecommend(@PathVariable String name) {
        SubDomain subDomain3= subDomainService.ideaRecommend(name);
        return subDomain3;
    }

    @PostMapping("/saved")
    public ResponseEntity<?> savedSubDomain(@RequestBody SubDomain subDomain)
    {
        subDomainService.saved(subDomain);
        return new ResponseEntity<SubDomain>(subDomainService.saved(subDomain), HttpStatus.CREATED);
    }







}
