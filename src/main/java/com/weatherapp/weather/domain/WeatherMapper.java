package com.weatherapp.weather.domain;

import com.weatherapp.infrastructure.weather.dto.WeatherHttpDto;

public class WeatherMapper {

    public static Weather mapToWeather(WeatherHttpDto weatherHttpDto) {
        Weather weather = new Weather();
        weather.setCity(weatherHttpDto.getCity());
        weather.setCountry(weatherHttpDto.getCountry());
        weather.setImage(weatherHttpDto.getImage());
        weather.setTemperature(weatherHttpDto.getTemperature());
        weather.setTimezone(weatherHttpDto.getTimezone());
        return weather;
    }
}
