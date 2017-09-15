/*
 * Project: SpringKafkaDEMO
 * 
 * File Created at 2016年12月8日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.curiousby.baoy.cn.kafka;

import java.util.Map;

import org.springframework.stereotype.Service;


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
