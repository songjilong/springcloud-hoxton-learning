package com.sjl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author songjilong
 * @date 2020/4/22 14:20
 */
@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 使用「自旋锁」和「CAS」增加请求次数
     */
    public final int incrementAndGet() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        // 实际调用服务器位置下标 = rest 接口第几次请求数 % 服务器集群总个数
        int index = incrementAndGet() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
