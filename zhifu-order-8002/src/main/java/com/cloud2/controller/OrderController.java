package com.cloud2.controller;

import com.cloud1.api.entities.CommonResult;
import com.cloud1.api.entities.Payment;
import com.cloud2.MyLoadB.MyLoadB;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-ZHIFU-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private MyLoadB myLoadB;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info(String.valueOf(payment));
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    //测试自编写的轮询（模仿ribbon的loadBalancer）
    @GetMapping(value = "/consumer/pay/port")
    public String getServerPort(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-ZHIFU-SERVICE");
        if (serviceInstances == null || serviceInstances.size() <= 0){
            return "Error:无法获取服务信息";
        }
        ServiceInstance serviceInstance = myLoadB.getService(serviceInstances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/pay/port",String.class);
    }
}
