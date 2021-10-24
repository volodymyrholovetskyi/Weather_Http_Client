package com.weatherapp.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("weather")
public class Weather {

    @Id
    private String id;
    private String city;
    private String country;
    private int temperature;
    private String image;
    private String timezone;
}
