package com.cloud1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OpenFeignMain8008 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain8008.class,args);
    }
}
