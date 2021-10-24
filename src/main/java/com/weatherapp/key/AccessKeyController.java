package com.weatherapp.key;

import com.weatherapp.key.dto.AccessKeyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("key")
public class AccessKeyController {

    private final AccessKeyService accessKeyService;

    @PostMapping()
    ModelAndView addAccessKey(@RequestBody AccessKeyDto accessKeyDto) {
//        accessKeyService.createAccessKey(accessKeyDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.CREATED);
        return modelAndView;
    }
}
