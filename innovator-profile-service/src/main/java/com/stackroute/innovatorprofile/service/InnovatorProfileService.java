package com.stackroute.innovatorprofile.service;


import com.stackroute.innovatorprofile.domain.InnovatorProfile;
import com.stackroute.innovatorprofile.exception.EmailIdAlreadyExistsException;

import java.util.List;

public interface InnovatorProfileService {
    public InnovatorProfile saveInnovatorProfile(InnovatorProfile innovatorProfile) throws EmailIdAlreadyExistsException;

    public List<InnovatorProfile> getInnovatorProfile();
}
