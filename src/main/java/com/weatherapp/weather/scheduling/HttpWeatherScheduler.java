package com.weatherapp.weather.scheduling;

import com.weatherapp.infrastructure.WeatherClient;
import com.weatherapp.weather.domain.Weather;
import com.weatherapp.weather.domain.WeatherRepository;
import com.weatherapp.weather.domain.WeatherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HttpWeatherScheduler {

   private static final  Logger LOG = LoggerFactory.getLogger(HttpWeatherScheduler.class);

    private final WeatherRepository weatherRepository;
    private final WeatherService weatherService;

    @Scheduled(fixedDelay = 1800_000) // 1800_000 ms = 30 min
    private Weather getWeather() throws IllegalAccessException {
        System.out.println("");
        Weather weather = weatherService.getWeatherForCity();
        Weather save = weatherRepository.save(weather);
        LOG.info("Add Weather: {}", save);
        return save;


    }
}
