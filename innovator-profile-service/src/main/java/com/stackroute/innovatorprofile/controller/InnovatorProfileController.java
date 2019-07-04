package com.stackroute.innovatorprofile.controller;

import com.stackroute.innovatorprofile.domain.InnovatorProfile;
import com.stackroute.innovatorprofile.exception.EmailIdAlreadyExistsException;
import com.stackroute.innovatorprofile.service.InnovatorProfileService;
import com.stackroute.innovatorprofile.service.InnovatorProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1")
public class InnovatorProfileController {

    private InnovatorProfileServiceImpl innovatorProfileSeviceimpl;

    @Autowired
    public InnovatorProfileController(InnovatorProfileServiceImpl innovatorProfileSeviceimpl) {
        this.innovatorProfileSeviceimpl = innovatorProfileSeviceimpl;
    }

    //method to save an innovator profile
    @PostMapping("/innovatorprofile")
    public ResponseEntity<?> saveInnovatorProfile(@RequestBody InnovatorProfile innovatorProfile) throws EmailIdAlreadyExistsException {
        ResponseEntity responseEntity;
        try {

            innovatorProfileSeviceimpl.saveInnovatorProfile(innovatorProfile);
            innovatorProfileSeviceimpl.send(innovatorProfile);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);


        }
        return responseEntity;
    }


    //method to get all the innovator profiles
    @GetMapping("/innovatorprofiles")
    public ResponseEntity<?> getInnovatorProfile() {
        return new ResponseEntity<List<InnovatorProfile>>(innovatorProfileSeviceimpl.getInnovatorProfile(), HttpStatus.OK);
    }

    @GetMapping("/getByEmailId/{emailId}")
    public ResponseEntity<?> getByEmailId(@PathVariable String emailId)
    {
        return new ResponseEntity<InnovatorProfile>(innovatorProfileSeviceimpl.getByEmailId(emailId),HttpStatus.OK);
    }
}


