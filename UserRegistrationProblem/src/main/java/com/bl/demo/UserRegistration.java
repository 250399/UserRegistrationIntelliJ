package com.bl.demo;

import java.util.regex.Pattern;

public class UserRegistration {
    public boolean validate(String patternString,String data){
        return Pattern.matches(patternString,data);
    }
}
