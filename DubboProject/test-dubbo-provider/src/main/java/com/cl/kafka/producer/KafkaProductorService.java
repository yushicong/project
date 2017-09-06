package com.cl.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.integration.kafka.support.KafkaHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;


@Service
public class KafkaProductorService {

    
    @Autowired
    @Qualifier("pChannel")
    private MessageChannel channel;

     
    public void sendInfo(String topic, Object obj) {
        System.out.println("---Service:KafkaService------sendInfo------");
        Message msg = MessageBuilder.withPayload(obj).setHeader(KafkaHeaders.TOPIC, topic).build();
        channel.send(msg);
    }
    
}
