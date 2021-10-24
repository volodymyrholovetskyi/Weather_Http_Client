package com.weatherapp.key.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessKeyDto {

    private String id;
    private String accessKey;
}
