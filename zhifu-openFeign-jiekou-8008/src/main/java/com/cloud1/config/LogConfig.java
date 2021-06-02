package com.cloud1.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LogConfig {

    @Bean
    Logger.Level OpenfeignLog(){
        return Logger.Level.FULL;
    }

}
