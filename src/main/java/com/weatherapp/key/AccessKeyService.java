package com.weatherapp.key;

import com.weatherapp.key.dto.AccessKeyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class AccessKeyService {

    private final AccessKeyRepository accessKeyRepository;

    @PostConstruct
    public void createAccessKey(){
        AccessKey accessKey = new AccessKey("1", "31f4a94d965b94e0752ee1f9f081927a");
//        accessKey.setAccessKyi("1");
//        accessKey.setAccessKyi("31f4a94d965b94e0752ee1f9f081927a");
        accessKeyRepository.save(accessKey);
    }
}
