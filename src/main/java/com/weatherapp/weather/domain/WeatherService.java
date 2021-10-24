package com.weatherapp.weather.domain;

import com.weatherapp.infrastructure.WeatherClient;
import com.weatherapp.infrastructure.weather.dto.WeatherHttpDto;
import com.weatherapp.key.AccessKey;
import com.weatherapp.key.AccessKeyQueryRepository;
import com.weatherapp.key.exception.AccessKeyNotFoundException;
import com.weatherapp.weather.domain.exceptions.WeatherNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;
    private final WeatherRepository weatherRepository;
    private final AccessKeyQueryRepository queryRepository;


    public Weather getWeatherForCity(String city) {
        String accessKey = getAccessKeyForHttpClient();
        System.out.println(accessKey);
        System.out.println(city);
        Optional<WeatherHttpDto> weatherHttpClient = weatherClient.getWeatherHttpClient(city, accessKey);
        Weather weather = WeatherMapper.mapToWeather(weatherHttpClient
                .orElseThrow(WeatherNotFoundException::new));
        return weatherRepository.save(weather);
    }

    private String getAccessKeyForHttpClient() {
        Optional<AccessKey> accessKeyById = queryRepository.findAccessKeyById("1");
        return accessKeyById
                .filter(keyId -> keyId.getId().equals("1"))
                .map(key -> key.getAccessKey())
                .orElseThrow(AccessKeyNotFoundException::new);
    }
}
