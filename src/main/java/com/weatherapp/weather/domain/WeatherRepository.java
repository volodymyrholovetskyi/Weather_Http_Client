package com.weatherapp.weather.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherRepository  extends MongoRepository<Weather, String>{

    Weather save(Weather weather);
}
