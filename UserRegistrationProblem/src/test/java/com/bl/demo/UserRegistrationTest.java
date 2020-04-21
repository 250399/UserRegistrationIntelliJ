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
    String lastNamePattern="^[A-Z][a-z]{2,}";
    String fullNamePattern="^[A-Z][a-z]{2,}[ ][A-Z][a-z]{2,}$";


    @Test
    public void testPasses_ForFirstName_WhenInputisValid(){
        Assert.assertTrue(obj.validate(firstNamePattern,"Kunal"));
    }

    @Test
    public void testPasses_ForFirstName_WhenInputisInvalid(){
        Assert.assertFalse(obj.validate(firstNamePattern,"kunal"));
    }

    @Test
    public void testPasses_ForLastName_WhenInputisValid(){
        Assert.assertTrue(obj.validate(lastNamePattern,"Kaneki"));
    }

    @Test
    public void testPasses_ForLastName_WhenInputisInvalid(){
        Assert.assertFalse(obj.validate(lastNamePattern,"kaneki"));
    }

    @Test
    public void testPasses_ForFullName_WhenInputisvalid(){
        Assert.assertTrue(obj.validate(fullNamePattern,"Kaneki Ken"));
    }

    @Test
    public void testPasses_ForFullName_WhenInputisInvalid(){
        Assert.assertFalse(obj.validate(fullNamePattern,"Kaneki ken"));
    }
}