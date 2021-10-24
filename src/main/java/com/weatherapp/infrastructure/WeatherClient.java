package com.weatherapp.infrastructure;

import com.weatherapp.infrastructure.weather.dto.WeatherHttpDto;

import java.util.Optional;

public interface WeatherClient {

    Optional<WeatherHttpDto> getWeatherHttpClient(String city, String accessKey) throws RuntimeException;
}
