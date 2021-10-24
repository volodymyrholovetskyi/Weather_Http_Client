package com.weatherapp.infrastructure.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class WeatherHttpDto {

    private String city;
    private String country;
    private int temperature;
    private String image;
    private String timezone;

}
