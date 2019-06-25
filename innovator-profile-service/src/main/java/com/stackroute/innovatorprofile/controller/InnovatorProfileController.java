package com.stackroute.innovatorprofile.controller;

import com.stackroute.innovatorprofile.domain.InnovatorProfile;
import com.stackroute.innovatorprofile.service.InnovatorProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

@RequestMapping(value ="api/v1")
public class InnovatorProfileController {

        InnovatorProfileServiceImpl innovatorProfileSeviceimpl;

        @Autowired
        public InnovatorProfileController(InnovatorProfileServiceImpl innovatorProfileSeviceimpl) {
            this.innovatorProfileSeviceimpl = innovatorProfileSeviceimpl;
        }

        @PostMapping("/innovatorprofile")
        public ResponseEntity<?> saveInnovatorProfile(@RequestBody InnovatorProfile innovatorProfile)
        {
            innovatorProfileSeviceimpl.send(innovatorProfile);
            return new ResponseEntity<InnovatorProfile>(innovatorProfileSeviceimpl.saveInnovatorProfile(innovatorProfile), HttpStatus.CREATED);
        }

    }


