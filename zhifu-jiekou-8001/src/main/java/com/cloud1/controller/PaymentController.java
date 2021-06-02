package com.cloud1.controller;

import com.cloud1.api.entities.CommonResult;
import com.cloud1.api.entities.Payment;
import com.cloud1.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*@RequestMapping + @Controller*/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPost;
    @Resource
    private PayService payService;
    //private Logger log;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = payService.create(payment);
        log.info("***写入结过:"+i+"    " +payment);
        if(i > 0){
            return new CommonResult(200,"写入成功"+" 端口号：" + serverPost,i);
        }else{
            return new CommonResult(400,"写入失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){
        Payment payment =  payService.getPaymentById(id);
        log.info("***查询结过:"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功"+" 端口号：" + serverPost,payment);
        }else{
            return new CommonResult(400,"查询失败",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> serveries = discoveryClient.getServices();
        for (String s : serveries){
            log.info("--serveries--" + s);
        }
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-ZHIFU-SERVICE");
        for (ServiceInstance serviceInstance:serviceInstances){
            log.info("服务名: " + serviceInstance.getInstanceId() + " 注册名: "
                    + serviceInstance.getHost() + " 端口号: " + serviceInstance.getPort() +
                    " url: "+ serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping(value = "/pay/port")
    public String getServerPost(){
        return serverPost;
    }

    @GetMapping(value = "/pay/time")
    public String getOpenFeignTime(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPost;
    }
    @GetMapping(value = "/pay/timeout")
    public String getOpenFeignTime2(){
        return payService.getPaymentTimeOut() + "--端口号：" + serverPost;
    }
    @GetMapping(value = "/pay/time2")
    public String getOpenFeignTime3(){
        return payService.getPaymentTime() + "--端口号：" + serverPost;
    }

    //服务熔断
    @GetMapping(value = "/pay/circuitBreaker/{i}")
    public String getCircuitBreaker(@PathVariable("i") int i){
        return payService.getCircuitBreaker(i);
    }
}
