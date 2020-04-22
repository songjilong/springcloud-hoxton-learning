package com.sjl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author songjilong
 * @date 2020/4/22 11:44
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule rule(){
        //随机
        return new RandomRule();
    }
}
