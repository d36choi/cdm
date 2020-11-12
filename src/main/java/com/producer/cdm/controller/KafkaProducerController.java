package com.producer.cdm.controller;


import com.producer.cdm.model.UberData;
import com.producer.cdm.repository.UberJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Iterator;
import java.util.Map;

@Slf4j
@Controller
public class KafkaProducerController {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;
    @Autowired
    UberJpaRepository uberJpaRepository;

    private static final String TOPICNAME = "test";

    @RequestMapping("/publish")
    @ResponseBody
    public String post(@RequestBody Map<String,Object> map)
    {
        for( Map.Entry<String, Object> elem : map.entrySet() ){

            kafkaTemplate.send(TOPICNAME, elem);
        }
        return "data is published!";
    }
}
