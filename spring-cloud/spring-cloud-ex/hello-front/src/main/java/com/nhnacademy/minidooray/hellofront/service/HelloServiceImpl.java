package com.nhnacademy.minidooray.hellofront.service;

import com.nhnacademy.minidooray.hellofront.adaptor.HelloAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceImpl implements HelloService {

    private final HelloAdaptor helloAdaptor;

    @Override
    public String callGateway() {
        return helloAdaptor.getApplicationInfo();
    }
}
