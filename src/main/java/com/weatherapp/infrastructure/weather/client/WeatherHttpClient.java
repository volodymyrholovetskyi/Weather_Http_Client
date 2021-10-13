package com.weatherapp.infrastructure.weather.client;

import com.weatherapp.infrastructure.WeatherClient;
import com.weatherapp.infrastructure.weather.dto.WeatherDTO;
import lombok.AllArgsConstructor;
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
    private static final String ACCESS_KEY = "31f4a94d965b94e0752ee1f9f081927a";

    private final RestTemplate restTemplate;
    private final String uri;


    @Override
    public Optional<WeatherDTO> getWeather(String city) throws RuntimeException {
        Map<String, String> params = new HashMap<>();
        params.put("query", city);
        params.put("access_key", ACCESS_KEY);

        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            final HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Optional<WeatherDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity,
                    new ParameterizedTypeReference<Optional<WeatherDTO>>() {
                    }, params);

            final Optional<WeatherDTO> body = response.getBody();
            LOG.info("Download weather: {}", body.get());
            return (body.isPresent() ? body : Optional.empty());

        } catch (RestClientException ex) {
            LOG.error(ex.getMessage());
            return Optional.empty();
        }
    }
}
