package com.stackroute.innovatorprofile.controller;

import com.stackroute.innovatorprofile.domain.InnovatorProfile;
import com.stackroute.innovatorprofile.exception.EmailIdAlreadyExistsException;
import com.stackroute.innovatorprofile.service.InnovatorProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(value ="api/v1")
public class InnovatorProfileController {

        InnovatorProfileServiceImpl innovatorProfileSeviceimpl;

        @Autowired
        public InnovatorProfileController(InnovatorProfileServiceImpl innovatorProfileSeviceimpl) {
            this.innovatorProfileSeviceimpl = innovatorProfileSeviceimpl;
        }

        @PostMapping("/innovatorprofile")
        public ResponseEntity<?>saveInnovatorProfile(@RequestBody InnovatorProfile innovatorProfile) throws EmailIdAlreadyExistsException{
            ResponseEntity responseEntity;
            try{

                innovatorProfileSeviceimpl.saveInnovatorProfile(innovatorProfile);
                innovatorProfileSeviceimpl.send(innovatorProfile);
                responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

            }catch (Exception ex){
                responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);


            }
            return responseEntity;}


        @GetMapping("/innovatorprofiles")
        public ResponseEntity<?> getInnovatorProfile()
        {
            return  new ResponseEntity<List<InnovatorProfile>>(innovatorProfileSeviceimpl.getInnovatorProfile(),HttpStatus.OK);
        }

    }


