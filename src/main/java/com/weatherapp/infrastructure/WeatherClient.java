package com.weatherapp.infrastructure;

import com.weatherapp.infrastructure.weather.dto.WeatherDTO;

import java.util.Optional;

public interface WeatherClient {

   Optional<WeatherDTO> getWeather(String city) throws RuntimeException;
}
