package com.weatherapp.key.exception;

public class AccessKeyNotFoundException extends RuntimeException{

    public AccessKeyNotFoundException(){
        super("Access key not found");
    }
}
