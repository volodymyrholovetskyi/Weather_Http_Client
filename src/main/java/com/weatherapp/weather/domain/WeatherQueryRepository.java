package com.weatherapp.weather.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WeatherQueryRepository extends MongoRepository<Weather, String> {

  Optional<Weather> findWeatherByCity(String city);
}
