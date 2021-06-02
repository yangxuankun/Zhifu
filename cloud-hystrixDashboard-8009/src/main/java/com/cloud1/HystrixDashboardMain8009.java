package com.cloud1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain8009 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain8009.class,args);
    }
}
