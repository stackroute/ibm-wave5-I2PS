package com.stackroute.innovatorprofile.service;

import com.stackroute.innovatorprofile.domain.InnovatorProfile;
import com.stackroute.innovatorprofile.repository.InnovatorProfileRespository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;

//import static jdk.internal.vm.compiler.word.LocationIdentity.any;
import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class InnovatorProfileServiceImplTest {
    @Autowired
    private MockMvc mockMvc;


    private InnovatorProfile innovatorProfile;

    //Create a mock for UserRepository
    @Mock
    private InnovatorProfileRespository innovatorProfileRespository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private InnovatorProfileServiceImpl innovatorProfileService;
    List<InnovatorProfile> list =null ;


    @Before
    public void setUp() throws Exception {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        innovatorProfile=new InnovatorProfile();
        innovatorProfile.setEmailId("sara43@gmail.com");
        innovatorProfile.setPassword("sara*56");
        innovatorProfile.setName("sara");
        list=new ArrayList<>();
        list.add(innovatorProfile);
    }


    @Test
    public void saveInnovatorProfile() {
        when(innovatorProfileService.saveInnovatorProfile((InnovatorProfile) any())).thenReturn(innovatorProfile);
        InnovatorProfile savedUser = innovatorProfileService.saveInnovatorProfile(innovatorProfile);
        Assert.assertEquals(innovatorProfile, savedUser);
        //verify here verifies that userRepository save method is only called once
        Mockito.verify(innovatorProfileRespository, times(1)).save(innovatorProfile);

  }
    @Test
    public void saveInnovatorProfileFailure() {
        when(innovatorProfileService.saveInnovatorProfile((InnovatorProfile) any())).thenReturn(null);
        InnovatorProfile savedUser = innovatorProfileService.saveInnovatorProfile(innovatorProfile);
        System.out.println("savedUser" + savedUser);
        Assert.assertNotEquals(innovatorProfile, savedUser);
    }

     @After
    public void tearDown() throws Exception {
  }
}