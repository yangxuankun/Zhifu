package com.cloud1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class ConsulController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/pay/consul")
    public String getServerPort(){
        return "StringCloud-Consul-serverPort:" + serverPort + "\n" + UUID.randomUUID();
    }
}
