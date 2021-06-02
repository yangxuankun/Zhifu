package com.cloud2.MyLoadB;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadB {
    ServiceInstance getService(List<ServiceInstance> serviceInstances);
}
