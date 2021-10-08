package com.cloudstreamrabbitmqconsumer8802.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
@Slf4j
public class ConsumerMessageService {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message)
    {

        log.info("收到消息"+message.getPayload());
    }

}
