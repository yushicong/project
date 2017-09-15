/*
 * Project: SpringKafkaDEMO
 * 
 * File Created at 2016年12月12日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.curiousby.baoy.cn.task;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.curiousby.baoy.cn.kafka.KafkaProductorService;


@Component("kafkaProductorServiceTask")
public class KafkaProductorServiceTask {

    @Resource
    KafkaProductorService kafkaProductorService;
    
    public void startTask(){
        kafkaProductorService.sendInfo("baoy-topic", "hello world");
    }

}


