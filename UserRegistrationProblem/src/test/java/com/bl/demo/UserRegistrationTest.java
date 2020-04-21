package com.bl.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
public class UserRegistrationTest {
    UserRegistration obj = new UserRegistration();
    String firstNamePattern="^[A-Z][a-z]{2,}";


    @Test
    public void testPasses_ForFirstName_WhenInputisValid(){
        Assert.assertTrue(obj.validate(firstNamePattern,"Kunal"));
    }

    @Test
    public void testPasses_ForFirstName_WhenInputisInvalid(){
        Assert.assertFalse(obj.validate(firstNamePattern,"kunal"));
    }

}