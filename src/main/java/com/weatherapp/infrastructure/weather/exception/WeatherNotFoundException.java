package com.weatherapp.infrastructure.weather.exception;

public class WeatherNotFoundException extends RuntimeException{

    public WeatherNotFoundException(){
        super(String.format("The weather cannot be null"));
    }
}
