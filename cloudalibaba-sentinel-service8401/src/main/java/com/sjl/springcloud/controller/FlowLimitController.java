package com.sjl.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.TimeUtil;
import io.micrometer.core.instrument.util.TimeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author songjilong
 * @date 2020/4/30 15:12
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "----testB";
    }

    @GetMapping("/topK")
    @SentinelResource(value = "topK", blockHandler = "topKHandler")
    public String testTopK(@RequestParam(value = "p1", required = false) String p1,
                           @RequestParam(value = "p2", required = false) String p2) {
        return "===topK ok===";
    }

    public String topKHandler(String p1, String p2, BlockException exception) {
        return "===topKHandler===";
    }
}
