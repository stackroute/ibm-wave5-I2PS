package com.stackroute.innovatorprofile.repository;

import com.stackroute.innovatorprofile.domain.InnovatorProfile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest

public class InnovatorProfileRepositoryTest {

    @Autowired
    private InnovatorProfileRespository innovatorProfileRespository;

    private InnovatorProfile innovatorProfile;
    @Before
    public void setUp() throws Exception {

        innovatorProfile = new InnovatorProfile();
        innovatorProfile = new InnovatorProfile();
        innovatorProfile.setEmailId("laxman567@gmail.com");
        innovatorProfile.setPassword("laxman*99940");
        innovatorProfile.setName("Laxman");
        innovatorProfile.setDomain("IT");


    }

    @Test
    public void testgetInnovatorProfile(){
        innovatorProfileRespository.save(innovatorProfile);
        List<InnovatorProfile> list = innovatorProfileRespository.findAll();
        System.out.println(list.get(0));
        Assert.assertEquals("monisha2701@gmail.com",list.get(0).getEmailId());

    }
}
