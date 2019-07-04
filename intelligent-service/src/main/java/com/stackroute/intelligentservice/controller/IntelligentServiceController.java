package com.stackroute.intelligentservice.controller;

import com.stackroute.intelligentservice.domain.IntelligentService;
import com.stackroute.intelligentservice.service.IntelligentSeviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class IntelligentServiceController {
    @Autowired
    IntelligentSeviceInterface intelligentSeviceInterface;

    public IntelligentSeviceInterface getIntelligentSeviceInterface() {
        return intelligentSeviceInterface;
    }

    public void setIntelligentSeviceInterface(IntelligentSeviceInterface intelligentSeviceInterface) {
        this.intelligentSeviceInterface = intelligentSeviceInterface;
    }


    @GetMapping("/getByRole/{role}")
    public ResponseEntity<?> getByRole(@PathVariable String role)
    {
        return new ResponseEntity<IntelligentService>(intelligentSeviceInterface.getByRole(role),HttpStatus.OK);
    }

}
