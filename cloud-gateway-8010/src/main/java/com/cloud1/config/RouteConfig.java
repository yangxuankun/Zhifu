package com.cloud1.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();
        builder.route("baidu_waiwang",r -> r.path("/article/details/106261042")
                .uri("https://zhaocunwei.blog.csdn.net/article/details/106261042"));
        /*builder.route("path_rote_atguigu", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei"));*/
        return builder.build();
    }
}
