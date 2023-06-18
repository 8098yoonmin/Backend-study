package com.nhnacademy.minidooray.hellofront.adaptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class HelloAdaptorImpl implements HelloAdaptor {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${gateway.port}")
    private String port;

    @Override
    public String getApplicationInfo() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        return restTemplate.exchange(
                "http://localhost:" + port + "/hello/custom-info",
                HttpMethod.GET,
                httpEntity,
                String.class
        ).getBody();
    }
}
