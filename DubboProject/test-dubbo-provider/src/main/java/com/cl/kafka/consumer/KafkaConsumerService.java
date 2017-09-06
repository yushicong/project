package com.cl.kafka.consumer;

import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class KafkaConsumerService {

    
    public void process(Map<String, Map<Integer, String>> msgs) {
        for (Map.Entry<String, Map<Integer, String>> entry : msgs.entrySet()) {
            System.out.println("======================================Consumer Message received: ");
            System.out.println("=====================================Suchit Topic:" + entry.getKey());
            for (String msg : entry.getValue().values()) {
                System.out.println("================================Suchit Consumed Message: " + msg);
            }
        }
    }

}
