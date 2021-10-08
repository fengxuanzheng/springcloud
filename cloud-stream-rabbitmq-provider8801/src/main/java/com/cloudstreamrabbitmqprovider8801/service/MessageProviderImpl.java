package com.cloudstreamrabbitmqprovider8801.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;


@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider{

    @Autowired
    private MessageChannel  output;
    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        System.out.println("消息发送成功");
        return null;
    }
}
