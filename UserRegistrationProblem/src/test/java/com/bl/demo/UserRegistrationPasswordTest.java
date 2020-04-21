package com.bl.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRegistrationPasswordTest {
    String passwordRule1;
    String passwordRule2;
    UserRegistration obj;

    @Before
    public void init(){
        obj=new UserRegistration();
        passwordRule1="[a-zA-Z0-9]{8,}";
        passwordRule2="(?=.*[A-Z])[a-zA-Z0-9]{8,}";
    }

    @Test
    public void testPasses_ifInput_MatchesPasswordRule1(){
        Assert.assertTrue(obj.validate(passwordRule1,"asdf12345"));
    }

    @Test
    public void testPasses_ifInput_DoesNotMatchesPasswordRule1(){
        Assert.assertFalse(obj.validate(passwordRule1,"asdf12"));
    }
    @Test
    public void testPasses_ifInput_MatchesPasswordRule2(){
        Assert.assertTrue(obj.validate(passwordRule2,"asdfA12345"));
    }

    @Test
    public void testPasses_ifInput_DoesNotMatchesPasswordRule2(){
        Assert.assertFalse(obj.validate(passwordRule2,"asdf12sadsad"));
    }
}