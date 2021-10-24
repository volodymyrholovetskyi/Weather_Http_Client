package com.weatherapp.infrastructure.weather.mapper;

import com.weatherapp.infrastructure.weather.dto.WeatherHttpDto;
import com.weatherapp.infrastructure.weather.models.Weather;

public class WeatherHttpMapper {

    public static WeatherHttpDto mapFromWeatherResponse(Weather weather){
        return WeatherHttpDto.builder()
                .city(weather.getLocation().getName())
                .country(weather.getLocation().getCountry())
                .timezone(weather.getLocation().getTimezone())
                .temperature(weather.getCurrent().getTemperature())
                .image(weather.getCurrent().getWeatherIcons().toString())
                .build();
    }
}
