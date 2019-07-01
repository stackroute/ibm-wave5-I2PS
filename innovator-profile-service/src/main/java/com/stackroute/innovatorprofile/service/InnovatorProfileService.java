package com.stackroute.innovatorprofile.service;


import com.stackroute.innovatorprofile.domain.InnovatorProfile;

import java.util.List;

public interface InnovatorProfileService {
    public InnovatorProfile saveInnovatorProfile(InnovatorProfile innovatorProfile);
    public List<InnovatorProfile> getInnovatorProfile();
}
