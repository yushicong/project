package com.ysc.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.kafka.support.KafkaHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class KafkaProductorService {

    @Autowired
    @Qualifier("pChannel")
    private MessageChannel messageChannel;

    public void sendInfo(String topic, Object obj) {
        System.out.println("---Service:KafkaService------sendInfo------");
        messageChannel.send(MessageBuilder.withPayload(obj).setHeader(KafkaHeaders.TOPIC,topic).build());
    }

}
