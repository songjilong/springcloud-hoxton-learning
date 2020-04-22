package com.sjl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author songjilong
 * @date 2020/4/22 14:19
 */
public interface LoadBalancer {
    /**
     * 获取服务实例
     * @param serviceInstances
     * @return
     */
    ServiceInstance getInstance(List<ServiceInstance>serviceInstances);
}
