package com.weatherapp.infrastructure.weather.client;

import com.weatherapp.infrastructure.WeatherClient;
import com.weatherapp.infrastructure.weather.dto.WeatherHttpDto;
import com.weatherapp.infrastructure.weather.mapper.WeatherHttpMapper;
import com.weatherapp.infrastructure.weather.models.Weather;
import lombok.AllArgsConstructor;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class WeatherHttpClient implements WeatherClient {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherHttpClient.class);

    private final RestTemplate restTemplate;
    private final String uri;

    @Override
    public Optional<WeatherHttpDto> getWeatherHttpClient(String city, String accessKey) throws RuntimeException {
        Map<String, String> params = getParameters(city, accessKey);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(httpHeaders);

        try {
            ResponseEntity<Weather> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity,
                    new ParameterizedTypeReference<Weather>() {
                    }, params);
            final var weatherResponse = response.getBody();
            WeatherHttpDto weatherHttpDto = WeatherHttpMapper.mapFromWeatherResponse(weatherResponse);
            LOG.info("Download weather: {}", weatherHttpDto);
            return Optional.ofNullable(weatherHttpDto);

        } catch (RestClientException ex) {
            LOG.error(ex.getMessage());
            return Optional.empty();
        }
    }

    private Map<String, String> getParameters(String city, String accessKey) {
        Map<String, String> params = new HashMap<>();
        params.put("query", city);
        params.put("accessKey", accessKey);
        return params;
    }

}
