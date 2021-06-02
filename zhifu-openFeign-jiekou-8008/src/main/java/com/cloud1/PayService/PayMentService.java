package com.cloud1.PayService;


import com.cloud1.PayService.Impl.PayMentImpl;
import com.cloud1.api.entities.CommonResult;
import com.cloud1.api.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.TimeUnit;

@Component
@FeignClient(value = "CLOUD-ZHIFU-SERVICE",fallback = PayMentImpl.class)
public interface PayMentService {
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment);
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id);
    @GetMapping(value = "/pay/time")
    public String getOpenFeignTime();
    @GetMapping(value = "/pay/timeout")
    public String getOpenFeignTimeOut();
    @GetMapping(value = "/pay/time2")
    public String getOpenFeignTime2();
}
