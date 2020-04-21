package com.bl.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UserRegistrationPhoneNoTest {
    String phonePattern;
    String input;
    boolean expectedValue;
    UserRegistration obj;

    public UserRegistrationPhoneNoTest(String input, boolean expectedValue){
        this.input=input;
        this.expectedValue=expectedValue;
    }

    @Before
    public void init(){
        obj=new UserRegistration();
        phonePattern="^[0-9]{2}[ ][0-9]{10}$";
    }

    @Parameterized.Parameters
    public static Collection checkPhoneNumber(){
        return Arrays.asList(new Object[][] {
                {"91 1231231234",true},
                {"911 1231231234",false },
                {"911231231234",false},
                {"91 123123123",false},
                {"91 123123123123",false}
        });
    }

    @Test
    public void validatePhoneNo(){
        Assert.assertEquals(expectedValue,obj.validate(phonePattern,input));
    }

}