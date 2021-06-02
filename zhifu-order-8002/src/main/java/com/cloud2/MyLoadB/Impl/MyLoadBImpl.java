package com.cloud2.MyLoadB.Impl;

import com.cloud2.MyLoadB.MyLoadB;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Component
public class MyLoadBImpl implements MyLoadB {

    //记录访问服务次数的原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getIndex(){
        int oldnumber,newnumber;
        do {
            oldnumber = atomicInteger.get();
            newnumber = oldnumber > 11 ? 0 : oldnumber + 1;
        }while(!atomicInteger.compareAndSet(oldnumber,newnumber));
        System.out.println("访问次数:" + newnumber);
        return newnumber;
    }
    //返回将要调用的server信息
    @Override
    public ServiceInstance getService(List<ServiceInstance> serviceInstances) {
        int index = getIndex() % serviceInstances.size();
        System.out.println("服务端口:" + serviceInstances.get(index).getPort());
        return serviceInstances.get(index);
    }
}
