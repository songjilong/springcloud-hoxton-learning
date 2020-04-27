package com.sjl.springcloud.controller;

import com.sjl.springcloud.service.impl.MessageProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songjilong
 * @date 2020/4/27 16:20
 */
@RestController
public class SendMessageController {

    @Autowired
    private MessageProviderImpl messageProvider;

    @GetMapping("/send/message")
    public String sendMessage(){
        messageProvider.send();
        return "success";
    }
}
