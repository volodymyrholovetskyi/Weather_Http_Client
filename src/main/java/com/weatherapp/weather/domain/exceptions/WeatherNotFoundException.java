package com.weatherapp.weather.domain.exceptions;

public class WeatherNotFoundException extends RuntimeException{

    public WeatherNotFoundException (){
        super("Weather not found");
    }


}
