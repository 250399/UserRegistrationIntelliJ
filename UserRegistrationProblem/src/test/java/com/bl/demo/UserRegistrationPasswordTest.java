package com.bl.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRegistrationPasswordTest {
    String passwordRule1;
    UserRegistration obj;

    @Before
    public void init(){
        obj=new UserRegistration();
        passwordRule1="[a-zA-Z0-9]{8,}";
    }

    @Test
    public void testPasses_ifInput_MatchesPasswordRule1(){
        Assert.assertTrue(obj.validate(passwordRule1,"asdf12345"));
    }

    @Test
    public void testPasses_ifInput_DoesNotMatchesPasswordRule1(){
        Assert.assertFalse(obj.validate(passwordRule1,"asdf12"));
    }
}