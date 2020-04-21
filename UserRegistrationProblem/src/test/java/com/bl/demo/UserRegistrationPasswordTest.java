package com.bl.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UserRegistrationPasswordTest {
    String passwordRule1;
    String passwordRule2;
    String passwordRule3;
    String passwordRule4;
    String input;
    boolean expectedValue;
    UserRegistration obj;


    @Before
    public void init(){
        obj=new UserRegistration();
        passwordRule1="[a-zA-Z0-9]{8,}";
        passwordRule2="(?=.*[A-Z])[a-zA-Z0-9]{8,}";
        passwordRule3="(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}";
        passwordRule4="^(?=.*[0-9])(?=.*[A-Z])(?=[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$).{8,}";
    }


    public UserRegistrationPasswordTest(String input, boolean expectedValue){
        this.input=input;
        this.expectedValue=expectedValue;
    }

    @Parameterized.Parameters
    public static Collection checkPassword(){
        return Arrays.asList(new Object[][]{
                {"@Kaneki322",true},
                {"@Kanek@322",false},
                {"Kaneki322",false}
        });
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
    @Test
    public void testPasses_ifInput_MatchesPasswordRule3(){
        Assert.assertTrue(obj.validate(passwordRule3,"asdfA12345"));
    }

    @Test
    public void testPasses_ifInput_DoesNotMatchesPasswordRule3(){
        Assert.assertFalse(obj.validate(passwordRule3,"asdfsadsad"));
    }

    public void validatePassword() {
    Assert.assertEquals(expectedValue,obj.validate(input,passwordRule4));
    }

}
