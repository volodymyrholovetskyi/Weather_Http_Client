package com.weatherapp.weather;

import com.weatherapp.weather.domain.Weather;
import com.weatherapp.weather.domain.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping()
    ModelAndView getWeatherForCity() {
        ModelAndView modelAndView = new ModelAndView("index");
//        Weather weatherForCity = weatherService.getWeatherForCity(city);
//        modelAndView.addObject(weatherForCity);
        modelAndView.setStatus(HttpStatus.CREATED);
        return modelAndView;
    }
}
