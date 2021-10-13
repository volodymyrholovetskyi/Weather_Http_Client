package com.weatherapp.config;

import com.weatherapp.infrastructure.weather.client.WeatherHttpClient;
import com.weatherapp.infrastructure.weather.error.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class Config {

    @Bean
    RestTemplateResponseErrorHandler restTemplateResponseErrorHandler() {
        return new RestTemplateResponseErrorHandler();
    }

    @Bean
    RestTemplate restTemplate(@Value("${2}") long connectionTimeout, @Value("${4}") long readiTimeout,
                              RestTemplateResponseErrorHandler errorHandler) {
        return new RestTemplateBuilder()
                .errorHandler(errorHandler)
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(readiTimeout))
                .build();
    }

    @Bean
    WeatherHttpClient weatherHttpClient(
            RestTemplate restTemplate,
            @Value("${weather.http.client.config.uri}") String uri) {
        return new WeatherHttpClient(restTemplate, uri);
    }
}
